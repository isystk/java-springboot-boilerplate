package com.isystk.sample.web.front.controller.api.v1.entry.remind;

import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.Resource;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.front.service.EntryRemindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.isystk.sample.common.Const.MESSAGE_SUCCESS;
import static com.isystk.sample.common.FrontUrl.API_V1_ENTRY_REMIND;
import static com.isystk.sample.common.FrontUrl.API_V1_ENTRY_REMIND_CONFIG;

/**
 * 会員パスワード変更
 */
@RestController
@RequestMapping(path = API_V1_ENTRY_REMIND, produces = MediaType.APPLICATION_JSON_VALUE)
public class EntryRemindRestController extends AbstractRestController {

  @Autowired
  EntryRemindService entryRemindService;

  @Autowired
  EntryRemindRestFormValidator entryRemindRestFormValidator;

  @ModelAttribute("entryRemindRestForm")
  public EntryRemindRestForm entryRemindRestForm() {
    return new EntryRemindRestForm();
  }

  @InitBinder("entryRemindRestForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(entryRemindRestFormValidator);
  }

  @Override
  public String getFunctionName() {
    return "API_ENTRY_REMIND";
  }

  /**
   * パスワード変更メール送信処理
   *
   * @param form
   * @param br
   * @param bindingResult
   * @return
   */
  @PostMapping
  public Resource registOnetimePass(@Validated @ModelAttribute EntryRemindRestForm form,
      BindingResult br,
      BindingResult bindingResult) {

    Resource resource = resourceFactory.create();

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      String message = "";
      for (FieldError fieldError : bindingResult.getFieldErrors()) {

        message += "<hr />Field:" + fieldError.getField();
        message += "<br />Code:" + fieldError.getCode();
        message += "<br />DefaultMessage:" + fieldError.getDefaultMessage();
      }
      resource.setMessage(message);
      return resource;
    }

    // パスワード変更ワンタイムパス登録
    entryRemindService.registOnetimePass(form.getEmail());

    resource.setMessage(getMessage(MESSAGE_SUCCESS));

    return resource;
  }


}
