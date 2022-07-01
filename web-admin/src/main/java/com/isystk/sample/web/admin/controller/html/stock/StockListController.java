package com.isystk.sample.web.admin.controller.html.stock;

import static com.isystk.sample.common.AdminUrl.STOCKS;

import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.web.admin.dto.StockSearchConditionDto;
import com.isystk.sample.web.admin.service.StockService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.base.view.CsvView;
import com.isystk.sample.web.base.view.ExcelView;
import com.isystk.sample.web.base.view.PdfView;
import java.math.BigInteger;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping(STOCKS)
public class StockListController extends AbstractHtmlController {

  @Autowired
  StockService stockService;

  @Autowired
  StockListFormValidator stockListFormValidator;

  @Override
  public String getFunctionName() {
    return "A_STOCK_LIST";
  }

  @ModelAttribute("stockListForm")
  public StockListForm stockListForm() {
    return new StockListForm();
  }

  @InitBinder("stockListForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(stockListFormValidator);
  }

  /**
   * 一覧画面表示
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping
  public String index(@ModelAttribute @Valid StockListForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return "modules/stock/list";
    }

    // 10件区切りで取得する
    val pages = stockService.findPage(formToDto(form), form);

    // 画面に検索結果を渡す
    model.addAttribute("pages", pages);

    return "modules/stock/list";
  }

  /**
   * 検索条件を詰める
   *
   * @return
   */
  private StockSearchConditionDto formToDto(
      StockListForm form) {

    // 入力値を詰め替える
    return ObjectMapperUtils.map(form, StockSearchConditionDto.class);
  }

  /**
   * 削除処理
   *
   * @param id
   * @return
   */
  @DeleteMapping("{id}")
  public String delete(@PathVariable BigInteger id) {
    stockService.delete(id);
    return "redirect:/stocks";
  }

  /**
   * CSVダウンロード
   *
   * @param filename
   * @return
   */
  @GetMapping("/download/{filename:.+\\.csv}")
  public CsvView downloadCsv(@PathVariable String filename, StockListForm form, Model model) {

    // 全件取得する
    val stocks = stockService.findAll(formToDto(form));

    // 詰め替える
    List<StockCsv> csvList = ObjectMapperUtils.mapAll(stocks, StockCsv.class);

    // CSVスキーマクラス、データ、ダウンロード時のファイル名を指定する
    return new CsvView(StockCsv.class, csvList, filename);
  }

  /**
   * Excelダウンロード
   *
   * @param filename
   * @return
   */
  @GetMapping(path = "/download/{filename:.+\\.xlsx}")
  public ModelAndView downloadExcel(@PathVariable String filename, StockListForm form,
      Model model) {

    // 全件取得する
    val stocks = stockService.findAll(formToDto(form));

    // Excelプック生成コールバック、データ、ダウンロード時のファイル名を指定する
    val view = new ExcelView(new StockExcel(), stocks, filename);

    return new ModelAndView(view);
  }

  /**
   * PDFダウンロード
   *
   * @param filename
   * @return
   */
  @GetMapping(path = "/download/{filename:.+\\.pdf}")
  public ModelAndView downloadPdf(@PathVariable String filename, StockListForm form, Model model) {

    // 全件取得する
    val stocks = stockService.findAll(formToDto(form));

    // 帳票レイアウト、データ、ダウンロード時のファイル名を指定する
    val view = new PdfView("reports/stocks.jrxml", stocks, filename);

    return new ModelAndView(view);
  }
}
