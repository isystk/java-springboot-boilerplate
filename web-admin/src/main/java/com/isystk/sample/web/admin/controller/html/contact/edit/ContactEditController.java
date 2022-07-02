package com.isystk.sample.web.admin.controller.html.contact.edit;

import static com.isystk.sample.common.AdminUrl.CONTACTS_EDIT;

import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.common.util.StringUtils;
import com.isystk.sample.common.values.Gender;
import com.isystk.sample.domain.dto.ContactFormImageRepositoryDto;
import com.isystk.sample.domain.dto.ContactFormRepositoryDto;
import com.isystk.sample.web.admin.service.ContactService;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.compress.utils.Lists;
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
@RequestMapping(CONTACTS_EDIT)
@SessionAttributes(types = {ContactEditForm.class})
public class ContactEditController extends AbstractHtmlController {

  @Autowired
  ContactService contactService;

  @Autowired
  ContactEditFormValidator contactEditFormValidator;

  @ModelAttribute("contactEditForm")
  public ContactEditForm contactEditForm() {
    return new ContactEditForm();
  }

  @InitBinder("contactEditForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(contactEditFormValidator);
  }

  @Override
  public String getFunctionName() {
    return "A_CONTACT_EDIT";
  }

  /**
   * 初期表示
   *
   * @param form
   * @param model
   * @return
   */
  @GetMapping("{contactId}")
  public String editIndex(@ModelAttribute ContactEditForm form, Model model) {

    // 1件取得する
    val contact = contactService.findById(form.getContactId());

    // 取得したDtoをFromに詰め替える
    ObjectMapperUtils.map(contact, form);

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
      ContactEditForm form, Model model) {
    return "modules/contact/edit/index";
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
  public String editConfirm(@Validated @ModelAttribute ContactEditForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return showEditIndex(form, model);
    }

    return "modules/contact/edit/confirm";
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
  public String editBack(@Validated @ModelAttribute ContactEditForm form, BindingResult br,
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
  public String updateComplete(@Validated @ModelAttribute ContactEditForm form, BindingResult br,
      SessionStatus sessionStatus, RedirectAttributes attributes, Model model) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return showEditIndex(form, model);
    }

    // 入力値を詰め替える
    val tContactsDto = ObjectMapperUtils.map(form, ContactFormRepositoryDto.class);
    if (!StringUtils.isBlankOrSpace(form.contactImageName) && !StringUtils.isBlankOrSpace(form.contactImageData)) {
      List<ContactFormImageRepositoryDto> imageList = Lists.newArrayList();
      var dto = new ContactFormImageRepositoryDto();
      dto.setContactImageName(form.getContactImageName());
      dto.setContactImageData(form.getContactImageData());
      imageList.add(dto);
      tContactsDto.setImageList(imageList);
    }
    tContactsDto.setId(form.getContactId());

    // 更新する
    contactService.update(tContactsDto);

    // セッションのcontactsEditFormをクリアする
    sessionStatus.setComplete();

    return "redirect:/contacts/edit/complete";
  }

  /**
   * 修正完了画面表示
   *
   * @return
   */
  @GetMapping("complete")
  public String showComplete() {
    return "modules/contact/edit/complete";
  }

}
