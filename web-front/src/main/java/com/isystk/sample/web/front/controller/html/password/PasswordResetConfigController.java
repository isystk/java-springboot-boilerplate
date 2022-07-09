package com.isystk.sample.web.front.controller.html.password;

import static com.isystk.sample.common.FrontUrl.PASSWORD_RESET_CONFIG;

import com.isystk.sample.web.base.controller.html.AbstractHtmlController;
import com.isystk.sample.web.front.service.PasswordResetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 会員パスワード変更
 */
@Controller
@Slf4j
@RequestMapping(path = PASSWORD_RESET_CONFIG)
public class PasswordResetConfigController extends AbstractHtmlController {

  @Autowired
  PasswordResetService passwordResetService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  PasswordResetConfigFormValidator passwordResetConfigFormValidator;

  @ModelAttribute("passwordResetConfigForm")
  public PasswordResetConfigForm passwordResetConfigForm() {
    return new PasswordResetConfigForm();
  }

  @InitBinder("passwordResetConfigForm")
  public void validatorBinder(WebDataBinder binder) {
    binder.addValidators(passwordResetConfigFormValidator);
  }

  @Override
  public String getFunctionName() {
    return "F_PASSWORD_RESET_CONFIG";
  }

  /**
   * パスワード変更処理
   *
   * @return
   */
  @PostMapping
  public String changePassword(@Validated @ModelAttribute PasswordResetConfigForm form,
      BindingResult br, RedirectAttributes attributes) {

    // 入力チェックエラーがある場合は、元の画面にもどる
    if (br.hasErrors()) {
      setFlashAttributeErrors(attributes, br);
      return "redirect:/password/reset/config";
    }

    // パスワードをハッシュ化する
    String password = passwordEncoder.encode(form.getPassword());

    // パスワード変更ワンタイムパス登録
    passwordResetService.changePassword(form.getOnetimeKey(), password);

    return "redirect:/password/reset/complete";
  }

}
