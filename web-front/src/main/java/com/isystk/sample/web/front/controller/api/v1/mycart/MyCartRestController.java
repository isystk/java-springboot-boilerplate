package com.isystk.sample.web.front.controller.api.v1.mycart;

import static com.isystk.sample.common.Const.MESSAGE_SUCCESS;
import static com.isystk.sample.common.FrontUrl.API_V1_MYCARTS;

import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.Resource;
import com.isystk.sample.web.front.service.CartService;
import java.math.BigInteger;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = API_V1_MYCARTS, produces = MediaType.APPLICATION_JSON_VALUE)
public class MyCartRestController extends AbstractRestController {

  @Autowired
  CartService cartService;

  @Override
  public String getFunctionName() {
    return "API_MYCARTS";
  }

  /**
   * マイカートを取得します。
   *
   * @return
   */
  @PostMapping
  public Resource index() {

    Resource resource = resourceFactory.create();
    resource.setData(Arrays.asList(cartService.searchCart()));
    resource.setMessage(getMessage(MESSAGE_SUCCESS));
    resource.setResult(true);

    return resource;
  }

  /**
   * マイカートに商品を追加します。
   *
   * @return
   */
  @PostMapping("/add")
  public Resource addCart(@RequestParam("stock_id") BigInteger stockId) {

    Resource resource = resourceFactory.create();
    resource.setData(Arrays.asList(cartService.addCart(stockId)));
    resource.setMessage(getMessage(MESSAGE_SUCCESS));
    resource.setResult(true);

    return resource;
  }

  /**
   * マイカートから商品を削除します。
   *
   * @return
   */
  @PostMapping("/remove")
  public Resource removeCart(@RequestParam("cart_id") BigInteger cartId) {

    Resource resource = resourceFactory.create();
    resource.setData(Arrays.asList(cartService.removeCart(cartId)));
    resource.setMessage(getMessage(MESSAGE_SUCCESS));
    resource.setResult(true);

    return resource;
  }

}
