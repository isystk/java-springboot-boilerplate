package com.isystk.sample.web.admin.controller.html.contact;

import static com.isystk.sample.common.AdminUrl.CONTACTS;

import com.isystk.sample.domain.dto.ContactFormRepositoryDto;
import com.isystk.sample.web.admin.service.ContactService;
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
@RequestMapping(CONTACTS)
public class ContactDetailController extends AbstractHtmlController {

  @Autowired
  ContactService contactService;

  @Override
  public String getFunctionName() {
    return "A_CONTACT_DETAIL";
  }

  /**
   * 詳細画面表示
   *
   * @param contactId
   * @param model
   * @return
   */
  @GetMapping("{contactId}")
  public String show(@PathVariable BigInteger contactId, Model model) {
    ContactFormRepositoryDto contact = contactService.findById(contactId);
    model.addAttribute("contact", contact);
    return "modules/contact/detail";
  }

}
