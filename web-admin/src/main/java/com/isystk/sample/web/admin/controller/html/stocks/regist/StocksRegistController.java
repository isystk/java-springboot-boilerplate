package com.isystk.sample.web.admin.controller.html.stocks.regist;

import static com.isystk.sample.common.AdminUrl.STOCKS_REGIST;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping(STOCKS_REGIST)
@SessionAttributes(types = {StocksRegistForm.class})
public class StocksRegistController extends AbstractHtmlController {

  @Autowired
  StockService stockService;

  @Autowired
  StocksRegistFormValidator stocksRegistFormValidator;

  @ModelAttribute("stocksRegistForm")
  public StocksRegistForm stocksRegistForm() {
    return new StocksRegistForm();
  }

  @InitBinder("stocksRegistForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(stocksRegistFormValidator);
  }

  @Override
  public String getFunctionName() {
    return "A_STOCKS_REGIST";
  }

  /**
   * 初期表示
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping
  public String registIndex(@ModelAttribute StocksRegistForm form, Model model) {

    // SessionAttributeを再生成する
    model.addAttribute("stocksRegistForm", new StocksRegistForm());

    return showRegistIndex(form, model);
  }

  /**
   * 登録画面表示
   *
   * @param form
   * @param model
   * @return
   */
  private String showRegistIndex(
      StocksRegistForm form, Model model) {
    return "modules/stocks/regist/index";
  }

  /**
   * 登録確認画面表示
   *
   * @param form
   * @param br
   * @param sessionStatus
   * @param attributes
   * @return
   */
  @PostMapping(params = "confirm")
  public String registConfirm(@Validated @ModelAttribute StocksRegistForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return showRegistIndex(form, model);
    }

    return "modules/stocks/regist/confirm";
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
  @PostMapping(params = "back")
  public String registBack(@Validated @ModelAttribute StocksRegistForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {
    return showRegistIndex(form, model);
  }

  /**
   * 登録処理
   *
   * @param form
   * @param br
   * @param sessionStatus
   * @param attributes
   * @return
   */
  @PostMapping(params = "complete")
  public String registComplete(@Validated @ModelAttribute StocksRegistForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return showRegistIndex(form, model);
    }

    // 入力値を詰め替える
    val tStocksDto = ObjectMapperUtils.map(form, StockRepositoryDto.class);

    // 登録する
    stockService.create(tStocksDto);

    // セッションのstocksRegistFormをクリアする
    sessionStatus.setComplete();

    return "redirect:/stocks/regist/complete";
  }

  /**
   * 登録完了画面表示
   *
   * @return
   */
  @GetMapping("complete")
  public String showComplete() {
    return "modules/stocks/regist/complete";
  }

}
