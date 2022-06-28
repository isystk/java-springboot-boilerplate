package com.isystk.sample.web.admin.controller.html.stocks.edit;

import static com.isystk.sample.common.AdminUrl.STOCKS_EDIT;

import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.repository.dto.StockRepositoryDto;
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
@SessionAttributes(types = {StocksEditForm.class})
public class StocksEditController extends AbstractHtmlController {

  @Autowired
  StockService stockService;

  @Autowired
  StocksEditFormValidator stocksEditFormValidator;

  @ModelAttribute("stocksEditForm")
  public StocksEditForm stocksEditForm() {
    return new StocksEditForm();
  }

  @InitBinder("stocksEditForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(stocksEditFormValidator);
  }

  @Override
  public String getFunctionName() {
    return "A_STOCKS_EDIT";
  }

  /**
   * 初期表示
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping("{stockId}")
  public String editIndex(@ModelAttribute StocksEditForm form, Model model) {

    // 1件取得する
    val stocks = stockService.findById(form.getStockId());

    // 取得したDtoをFromに詰め替える
    ObjectMapperUtils.map(stocks, form);

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
      StocksEditForm form, Model model) {
    return "modules/stocks/edit/index";
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
  public String editConfirm(@Validated @ModelAttribute StocksEditForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return showEditIndex(form, model);
    }

    return "modules/stocks/edit/confirm";
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
  public String editBack(@Validated @ModelAttribute StocksEditForm form, BindingResult br,
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
  public String updateComplete(@Validated @ModelAttribute StocksEditForm form, BindingResult br,
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
    return "modules/stocks/edit/complete";
  }

}
