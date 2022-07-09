package com.isystk.sample.web.front.controller.html.password;

import static com.isystk.sample.common.FrontUrl.PASSWORD_RESET;

import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.front.service.PasswordResetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * パスワードリセット
 */
@Controller
@Slf4j
@RequestMapping(path = PASSWORD_RESET)
public class PasswordResetController extends AbstractHtmlController {

  @Autowired
  PasswordResetService passwordResetService;

  @Autowired
  PasswordResetFormValidator passwordResetFormValidator;

  @ModelAttribute("entryRemindForm")
  public PasswordResetForm entryRemindForm() {
    return new PasswordResetForm();
  }

  @InitBinder("entryRemindForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(passwordResetFormValidator);
  }

  @Override
  public String getFunctionName() {
    return "F_PASSWORD_RESET";
  }

  /**
   * パスワード変更メール送信処理
   *
   * @param form
   * @param br
   * @return
   */
  @PostMapping
  public String registOnetimePass(@Validated @ModelAttribute PasswordResetForm form,
      BindingResult br, RedirectAttributes attributes) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return "redirect:/password/reset";
    }

    // パスワード変更ワンタイムパス登録
    passwordResetService.registOnetimePass(form.getEmail());

    return "redirect:/password/reset/sendMail";
  }


}
