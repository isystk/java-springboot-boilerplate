package com.isystk.sample.web.admin.controller.html.order;

import static com.isystk.sample.common.AdminUrl.ORDERS;

import com.isystk.sample.domain.dto.OrderHistoryRepositoryDto;
import com.isystk.sample.web.admin.service.OrderHistoryService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import java.math.BigInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(ORDERS)
public class OrderDetailController extends AbstractHtmlController {

  @Autowired
  OrderHistoryService orderHistoryService;

  @Override
  public String getFunctionName() {
    return "A_ORDER_DETAIL";
  }

  /**
   * 詳細画面表示
   *
   * @param orderId
   * @param model
   * @return
   */
  @GetMapping("{orderId}")
  public String show(@PathVariable BigInteger orderId, Model model) {
    OrderHistoryRepositoryDto order = orderHistoryService.findById(orderId);
    model.addAttribute("order", order);
    return "modules/order/detail";
  }

}
