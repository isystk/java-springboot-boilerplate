package com.isystk.sample.web.admin.controller.html.order;

import static com.isystk.sample.common.AdminUrl.ORDERS;

import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dto.OrderHistoryCriteria;
import com.isystk.sample.web.admin.dto.OrderHistorySearchConditionDto;
import com.isystk.sample.web.admin.service.OrderHistoryService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import java.time.LocalTime;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping(ORDERS)
public class OrderListController extends AbstractHtmlController {

  @Autowired
  OrderHistoryService orderHistoryService;

  @Autowired
  OrderListFormValidator orderListFormValidator;

  @Override
  public String getFunctionName() {
    return "A_ORDER_LIST";
  }

  @ModelAttribute("orderListForm")
  public OrderListForm orderListForm() {
    return new OrderListForm();
  }

  @InitBinder("orderListForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(orderListFormValidator);
  }

  /**
   * 一覧画面表示
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping
  public String index(@ModelAttribute @Valid OrderListForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return "modules/order/list";
    }

    // 10件区切りで取得する
    val pages = orderHistoryService.findPage(formToDto(form), form);

    // 画面に検索結果を渡す
    model.addAttribute("pages", pages);

    return "modules/order/list";
  }

  /**
   * 検索条件を詰める
   *
   * @return
   */
  private OrderHistorySearchConditionDto formToDto(
      OrderListForm form) {

    // 入力値を詰め替える
    return ObjectMapperUtils.map(form, OrderHistorySearchConditionDto.class);
  }

}
