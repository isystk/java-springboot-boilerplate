package com.isystk.sample.domain.repository;

import static java.util.stream.Collectors.toList;

import com.google.common.collect.Maps;
import com.isystk.sample.common.dto.StripePaymentDto;
import com.isystk.sample.common.dto.mail.MailStockPaymentComplete;
import com.isystk.sample.common.exception.ErrorMessagesException;
import com.isystk.sample.common.exception.SystemException;
import com.isystk.sample.common.helper.SendMailHelper;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.common.values.MailTemplateDiv;
import com.isystk.sample.domain.dao.CartDao;
import com.isystk.sample.domain.dao.OrderHistoryDao;
import com.isystk.sample.domain.dao.StockDao;
import com.isystk.sample.domain.dto.CartCriteria;
import com.isystk.sample.domain.dto.CartRepositoryDto;
import com.isystk.sample.domain.dto.StockCriteria;
import com.isystk.sample.domain.entity.Cart;
import com.isystk.sample.domain.entity.OrderHistory;
import com.isystk.sample.domain.entity.Stock;
import com.isystk.sample.domain.entity.User;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.val;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * マイカートリポジトリ
 */
@Repository
public class CartRepository extends BaseRepository {

  private static final Log logger = LogFactory.getLog(CartRepository.class);

  @Value("${spring.mail.properties.mail.from}")
  String fromAddress;

  @Value("${stripe.apiSecret}")
  String apiSecret;

  @Autowired
  StockDao stockDao;

  @Autowired
  CartDao cartDao;

  @Autowired
  OrderHistoryDao orderHistoryDao;

  @Autowired
  MailTemplateRepository mailTemplateRepository;

  @Autowired
  SendMailHelper sendMailHelper;

  /**
   * ユーザに紐づくカート情報を複数取得します。
   *
   * @param userId
   * @return
   */
  public List<CartRepositoryDto> findCart(BigInteger userId) {
    CartCriteria criteria = new CartCriteria();
    criteria.setUserIdEq(userId);
    return convertCartDto(cartDao.findAll(criteria));
  }

  /**
   * RepositoryDto に変換します。
   *
   * @param cartList
   * @return
   */
  private List<CartRepositoryDto> convertCartDto(List<Cart> cartList) {
    // cartListからstockIdのListを抽出
    List<BigInteger> stockIdList = cartList.stream().map(e -> e.getStockId())
        .collect(Collectors.toList());

    // stockId をkeyとした、stockListのMapを生成
    StockCriteria stockCriteria = new StockCriteria();
    stockCriteria.setIdIn(stockIdList);
    Map<BigInteger, List<Stock>> stockMap = stockDao.findAll(stockCriteria)
        .stream().collect(Collectors.groupingBy(Stock::getId));

    // cartList を元に、cartDtoList へコピー
    var cartDtoList =  ObjectMapperUtils.mapAll(cartList, CartRepositoryDto.class)
    .stream().map((e) -> {
      e.setStock(stockMap.get(e.getStockId()).get(0));
      return e;
    }).collect(toList());
    return cartDtoList;
  }

  /**
   * ユーザに紐づくカートに商品を追加します。
   *
   * @param userId
   * @param stockId
   * @return
   */
  public List<CartRepositoryDto> addCart(BigInteger userId, BigInteger stockId) {
    val time = DateUtils.getNow();

    // 商品テーブル
    val cart = new Cart();
    cart.setUserId(userId);
    cart.setStockId(stockId);
    cart.setCreatedAt(time); // 作成日
    cart.setUpdatedAt(time); // 更新日
    cart.setDeleteFlg(false); // 削除フラグ
    cart.setVersion(0L); // 楽観ロック改定番号
    cartDao.insert(cart);

    return findCart(userId);
  }

  /**
   * ユーザに紐づくカートから商品を削除します。
   *
   * @param userId
   * @param cartId
   * @return
   */
  public List<CartRepositoryDto> removeCart(BigInteger userId, BigInteger cartId) {
    var cart = cartDao.selectById(cartId).orElseThrow();
    cartDao.delete(cart);
    return findCart(userId);
  }

  /**
   * Stripeの支払情報を生成します。
   * @param user
   * @param amount
   * @param email
   */
  public StripePaymentDto createPayment(User user, Integer amount, String email) {

    var cartList = findCart(user.getId());

    // stockId をkeyとした、cartListのMapを生成
    Map<BigInteger, List<CartRepositoryDto>> cartMap = cartList
        .stream().collect(Collectors.groupingBy(Cart::getStockId));

    // ユニークなstockIdを取得
    List<BigInteger> stockIdList = cartList.stream().map(e -> e.getStockId()).distinct().collect(toList());

    // 発注履歴に追加する。
    stockIdList.stream().forEach((stockId) -> {
      var stockCartList = cartMap.get(stockId);
      Stock cartStock = stockCartList.get(0).getStock();

      var quantity = stockCartList.size();
      if (cartStock.getQuantity() < quantity) {
        // 在庫が不足している場合はエラーとする
        throw new ErrorMessagesException("在庫が不足しています。stockId:" + stockId);
      }
    });

    StripePaymentDto dto = new StripePaymentDto();
    Stripe.apiKey = apiSecret;
    Map<String, Object> metadata = Maps.newHashMap();
    metadata.put("username", email);
    Map<String, Object> params = Maps.newHashMap();
    params.put("amount", amount);
    params.put("description", "LaraEC");
    params.put("currency", "jpy");
    params.put("metadata", metadata);
    try {
      PaymentIntent paymentIntent = PaymentIntent.create(params);
      dto.setClientSecret(paymentIntent.getClientSecret());
    } catch (StripeException e) {
      throw new SystemException(e);
    }
    return dto;
  }

  /**
   * 決算処理完了後の後処理をします。
   * @param user
   * @return
   */
  public boolean checkout(User user) {
    val time = DateUtils.getNow();

    var cartList = findCart(user.getId());

    // stockId をkeyとした、cartListのMapを生成
    Map<BigInteger, List<CartRepositoryDto>> cartMap = cartList
        .stream().collect(Collectors.groupingBy(Cart::getStockId));

    // ユニークなstockIdを取得
    List<BigInteger> stockIdList = cartList.stream().map(e -> e.getStockId()).distinct().collect(toList());

    // 発注履歴に追加する。
    stockIdList.stream().forEach((stockId) -> {
      var stockCartList = cartMap.get(stockId);
      Stock cartStock = stockCartList.get(0).getStock();

      var quantity = stockCartList.size();
      if (cartStock.getQuantity() < quantity) {
        // 在庫が不足している場合はエラーとする
        throw new ErrorMessagesException("在庫が不足しています。stockId:" + stockId);
      }

      // 在庫を減らす
      Stock stock = stockDao.selectById(cartStock.getId()).orElseThrow();
      stock.setQuantity(stock.getQuantity()-quantity);
      stock.setUpdatedAt(time); // 更新日
      stockDao.update(stock);

      // 注文履歴テーブル
      OrderHistory orderHistory = new OrderHistory();
      orderHistory.setStockId(stockId);
      orderHistory.setUserId(user.getId());
      orderHistory.setPrice(cartStock.getPrice());
      orderHistory.setQuantity(quantity);
      orderHistory.setCreatedAt(time); // 作成日
      orderHistory.setUpdatedAt(time); // 更新日
      orderHistory.setDeleteFlg(false); // 削除フラグ
      orderHistory.setVersion(0L); // 楽観ロック改定番号
      orderHistoryDao.insert(orderHistory);
    });

    // カートから商品を削除
    cartList.stream().forEach(e -> {
      removeCart(user.getId(), e.getId());
    });

    // ユーザ宛に購入完了メール送信
    int amount = cartList.stream().mapToInt(e->e.getStock().getPrice()).sum();
    val mailTemplate = mailTemplateRepository.getMailTemplate(MailTemplateDiv.STOCK_PAYMENT_COMPLETE);
    val subject = mailTemplate.getTitle();
    val templateBody = mailTemplate.getText();
    var dto = new MailStockPaymentComplete();
    dto.setUserName(user.getName());
    dto.setAmount(amount);
    Map<String, Object> objects = Maps.newHashMap();
    objects.put("dto", dto);
    val body = sendMailHelper.getMailBody(templateBody, objects);
    sendMailHelper.sendMail(fromAddress, user.getEmail(), subject, body);

    return true;
  }

}
