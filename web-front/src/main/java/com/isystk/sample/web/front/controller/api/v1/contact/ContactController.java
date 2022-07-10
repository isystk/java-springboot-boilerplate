package com.isystk.sample.web.front.controller.api.v1.contact;

import static com.isystk.sample.common.Const.MESSAGE_SUCCESS;
import static com.isystk.sample.common.FrontUrl.API_V1_CONTACTS;

import com.google.common.collect.Lists;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.common.util.StringUtils;
import com.isystk.sample.domain.dto.ContactFormImageRepositoryDto;
import com.isystk.sample.domain.dto.ContactFormRepositoryDto;
import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.Resource;
import com.isystk.sample.web.front.service.ContactService;
import java.util.List;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = API_V1_CONTACTS, produces = MediaType.APPLICATION_JSON_VALUE)
public class ContactController extends AbstractRestController {

  @Autowired
  ContactService contactService;

  @Override
  public String getFunctionName() {
    return "API_CONTACTS";
  }

  @Autowired
  ContactFormValidator contactFormValidator;

  @ModelAttribute("form")
  public ContactForm initForm() {
    return new ContactForm();
  }

  @InitBinder("form")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(contactFormValidator);
  }

  /**
   * お問い合わせを登録します。
   *
   * @return
   */
  @PostMapping("/regist")
  public Resource regist(@Validated @ModelAttribute("form") ContactForm form, BindingResult br) {
    Resource resource = resourceFactory.create();

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      // TODO エラーメッセージを返却できるようにしたい
      resource.setMessage(getMessage(VALIDATION_ERROR));
      resource.setResult(false);
      return resource;
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

    // 登録する
    contactService.create(tContactsDto);

    resource.setMessage(getMessage(MESSAGE_SUCCESS));
    resource.setResult(true);
    return resource;
  }

}
