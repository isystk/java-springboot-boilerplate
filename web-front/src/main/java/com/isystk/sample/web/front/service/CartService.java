package com.isystk.sample.web.front.service;

import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.domain.dto.CartRepositoryDto;
import com.isystk.sample.domain.entity.User;
import com.isystk.sample.domain.repository.CartRepository;
import com.isystk.sample.web.front.dto.CartSearchResultDto;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import org.castor.core.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService extends BaseTransactionalService {

  @Autowired
  CartRepository cartRepository;

  @Autowired
  UserHelper userHelper;

  /**
   * ログイン中のユーザのカート情報を取得します。
   *
   * @return
   */
  public CartSearchResultDto searchCart() {
    var user = userHelper.getUser();
    Assert.notNull(user, "user must not be null");

    var cartList = cartRepository.findCart(user.getId());

    CartSearchResultDto dto = new CartSearchResultDto();
    dto.setCartList(cartList);
    dto.setCount(cartList.size());
    dto.setSum(cartList.stream().map(e -> e.getStock().getPrice())
        .collect(Collectors.summingInt(Integer::intValue)));
    dto.setUsername(user.getName());

    return dto;
  }

  /**
   * ログイン中のユーザのカートに商品を追加します。
   *
   * @return
   */
  public CartSearchResultDto addCart(BigInteger stockId) {
    var user = userHelper.getUser();
    Assert.notNull(user, "user must not be null");

    var cartList = cartRepository.addCart(user.getId(), stockId);
    return convertCartSearchResultDto(user, cartList);
  }

  private CartSearchResultDto convertCartSearchResultDto(User user, List<CartRepositoryDto> cartList) {
    var dto = new CartSearchResultDto();
    dto.setCartList(cartList);
    dto.setCount(cartList.size());
    dto.setSum(cartList.stream().map(e -> e.getStock().getPrice())
        .collect(Collectors.summingInt(Integer::intValue)));
    dto.setUsername(user.getName());
    return dto;
  }

  /**
   * ログイン中のユーザのカートに商品を追加します。
   *
   * @return
   */
  public CartSearchResultDto removeCart(BigInteger cartId) {
    var user = userHelper.getUser();
    Assert.notNull(user, "user must not be null");

    var cartList = cartRepository.removeCart(user.getId(), cartId);
    return convertCartSearchResultDto(user, cartList);
  }
}
