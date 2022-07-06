package com.isystk.sample.domain.repository;

import static java.util.stream.Collectors.toList;

import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dao.CartDao;
import com.isystk.sample.domain.dao.StockDao;
import com.isystk.sample.domain.dto.CartCriteria;
import com.isystk.sample.domain.dto.CartRepositoryDto;
import com.isystk.sample.domain.dto.StockCriteria;
import com.isystk.sample.domain.entity.Cart;
import com.isystk.sample.domain.entity.Stock;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * マイカートリポジトリ
 */
@Repository
public class CartRepository extends BaseRepository {

  @Autowired
  StockDao stockDao;

  @Autowired
  CartDao cartDao;

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

}
