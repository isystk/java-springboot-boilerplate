package com.isystk.sample.web.front.controller.api.v1.entry;

import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.entity.TUser;
import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.Resource;
import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.front.dto.FrontPostDto;
import com.isystk.sample.web.front.service.EntryService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
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

import java.util.Arrays;

import static com.isystk.sample.common.Const.MESSAGE_SUCCESS;
import static com.isystk.sample.common.FrontUrl.API_V1_ENTRY_REGIST;
import static com.isystk.sample.common.FrontUrl.API_V1_POSTS;

/**
 * 会員登録
 */
@RestController
@RequestMapping(path = API_V1_ENTRY_REGIST, produces = MediaType.APPLICATION_JSON_VALUE)
public class EntryRestController extends AbstractRestController {

  @Autowired
  EntryService entryService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  EntryRestFormValidator entryFormValidator;

  @ModelAttribute("entryRestForm")
  public EntryRestForm entryRestForm() {
    return new EntryRestForm();
  }

  @InitBinder("entryRestForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(entryFormValidator);
  }

  @Override
  public String getFunctionName() {
    return "API_ENTRY";
  }

  /**
   * 仮会員登録処理
   *
   * @param form
   * @param br
   * @param bindingResult
   * @return
   */
  @PostMapping
  public Resource ontime(@Validated @ModelAttribute EntryRestForm form, BindingResult br,
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

    // 入力値からDTOを作成する
    val inputUser = ObjectMapperUtils.map(form, TUser.class);
    val password = form.getPassword();

    // パスワードをハッシュ化する
    inputUser.setPassword(passwordEncoder.encode(password));

    // 仮会員登録
    entryService.registTemporary(inputUser);

    resource.setMessage(getMessage(MESSAGE_SUCCESS));

    return resource;
  }

  /**
   * 本会員登録処理
   *
   * @param onetimeKey
   * @return
   */
  @PutMapping("{onetimeKey}")
  public Resource complete(@PathVariable String onetimeKey, Model model) {

    Resource resource = resourceFactory.create();

    // 本会員登録
    entryService.registComplete(onetimeKey);

    resource.setMessage(getMessage(MESSAGE_SUCCESS));

    return resource;
  }

}
