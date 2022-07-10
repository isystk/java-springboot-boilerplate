package com.isystk.sample.web.admin.controller.html.photo;

import static com.isystk.sample.common.AdminUrl.PHOTOS;

import com.isystk.sample.web.admin.service.PhotoService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping(PHOTOS)
public class PhotoListController extends AbstractHtmlController {

  @Autowired
  PhotoService photoService;

  @Autowired
  PhotoListFormValidator photoListFormValidator;

  @Override
  public String getFunctionName() {
    return "A_PHOTO_LIST";
  }

  @ModelAttribute
  public PhotoListForm initForm() {
    return new PhotoListForm();
  }

  @InitBinder
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(photoListFormValidator);
  }

  /**
   * 一覧画面表示
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping
  public String index(@ModelAttribute @Valid PhotoListForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return "modules/photo/list";
    }

    // 10件区切りで取得する
    val pages = photoService.findAll(form.getName());

    // 画面に検索結果を渡す
    model.addAttribute("pages", pages);

    return "modules/photo/list";
  }

  /**
   * 削除処理
   *
   * @param imageName
   * @return
   */
  @DeleteMapping()
  public String delete(@RequestParam(value = "name") String imageName) {
    photoService.delete(imageName);
    return "redirect:/photos";
  }

}
