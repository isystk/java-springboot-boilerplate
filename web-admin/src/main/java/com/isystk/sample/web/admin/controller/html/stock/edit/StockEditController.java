package com.isystk.sample.web.admin.controller.html.stock.edit;

import static com.isystk.sample.common.AdminUrl.STOCKS_EDIT;

import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dto.StockRepositoryDto;
import com.isystk.sample.web.admin.service.StockService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping(STOCKS_EDIT)
@SessionAttributes(types = {StockEditForm.class})
public class StockEditController extends AbstractHtmlController {

  @Autowired
  StockService stockService;

  @Autowired
  StockEditFormValidator stockEditFormValidator;

  @ModelAttribute("stockEditForm")
  public StockEditForm stockEditForm() {
    return new StockEditForm();
  }

  @InitBinder("stockEditForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(stockEditFormValidator);
  }

  @Override
  public String getFunctionName() {
    return "A_STOCK_EDIT";
  }

  /**
   * 初期表示
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping("{stockId}")
  public String editIndex(@ModelAttribute StockEditForm form, Model model) {

    // 1件取得する
    val stock = stockService.findById(form.getStockId());

    // 取得したDtoをFromに詰め替える
    ObjectMapperUtils.map(stock, form);

    return showEditIndex(form, model);
  }

  /**
   * 修正画面表示
   *
   * @param form
   * @param model
   * @return
   */
  private String showEditIndex(
      StockEditForm form, Model model) {
    return "modules/stock/edit/index";
  }

  /**
   * 修正確認画面表示
   *
   * @param form
   * @param br
   * @param sessionStatus
   * @param attributes
   * @return
   */
  @PutMapping(params = "confirm")
  public String editConfirm(@Validated @ModelAttribute StockEditForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return showEditIndex(form, model);
    }

    return "modules/stock/edit/confirm";
  }

  /**
   * 前に戻る
   *
   * @param form
   * @param br
   * @param sessionStatus
   * @param attributes
   * @return
   */
  @PutMapping(params = "back")
  public String editBack(@Validated @ModelAttribute StockEditForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {
    return showEditIndex(form, model);
  }

  /**
   * 更新処理
   *
   * @param form
   * @param br
   * @param sessionStatus
   * @param attributes
   * @return
   */
  @PutMapping(params = "complete")
  public String updateComplete(@Validated @ModelAttribute StockEditForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return showEditIndex(form, model);
    }

    // 入力値を詰め替える
    val tStocksDto = ObjectMapperUtils.map(form, StockRepositoryDto.class);
    tStocksDto.setId(form.getStockId());

    // 更新する
    stockService.update(tStocksDto);

    // セッションのstocksEditFormをクリアする
    sessionStatus.setComplete();

    return "redirect:/stocks/edit/complete";
  }

  /**
   * 修正完了画面表示
   *
   * @return
   */
  @GetMapping("complete")
  public String showComplete() {
    return "modules/stock/edit/complete";
  }

}
