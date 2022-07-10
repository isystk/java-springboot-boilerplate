package com.isystk.sample.web.admin.controller.html.contact;

import static com.isystk.sample.common.AdminUrl.CONTACTS;

import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.web.admin.dto.ContactSearchConditionDto;
import com.isystk.sample.web.admin.service.ContactService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import java.math.BigInteger;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping(CONTACTS)
public class ContactListController extends AbstractHtmlController {

  @Autowired
  ContactService contactService;

  @Autowired
  ContactListFormValidator contactListFormValidator;

  @Override
  public String getFunctionName() {
    return "A_CONTACT_LIST";
  }

  @ModelAttribute
  public ContactListForm initForm() {
    return new ContactListForm();
  }

  @InitBinder
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(contactListFormValidator);
  }

  /**
   * 一覧画面表示
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping
  public String index(@ModelAttribute @Valid ContactListForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return "modules/contact/list";
    }

    // 10件区切りで取得する
    val pages = contactService.findPage(formToDto(form), form);

    // 画面に検索結果を渡す
    model.addAttribute("pages", pages);

    return "modules/contact/list";
  }

  /**
   * 検索条件を詰める
   *
   * @return
   */
  private ContactSearchConditionDto formToDto(
      ContactListForm form) {

    // 入力値を詰め替える
    return ObjectMapperUtils.map(form, ContactSearchConditionDto.class);
  }

  /**
   * 削除処理
   *
   * @param id
   * @return
   */
  @DeleteMapping("{id}")
  public String delete(@PathVariable BigInteger id) {
    contactService.delete(id);
    return "redirect:/contacts";
  }

}
