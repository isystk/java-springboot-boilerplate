package com.isystk.sample.web.front.controller.html.password.config;

import static com.isystk.sample.common.util.ValidateUtils.isNotEquals;

import com.isystk.sample.common.validator.AbstractValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * 会員パスワード変更 入力チェック
 */
@Component
public class PasswordResetConfigFormValidator extends
    AbstractValidator<PasswordResetConfigForm> {

  @Override
  protected void doValidate(
      PasswordResetConfigForm form, Errors errors) {
    // 確認用パスワードと突き合わせる
    if (isNotEquals(form.getPassword(), form.getPasswordConfirmation())) {
      errors.rejectValue("password", "errros.unmatchPassword");
      errors.rejectValue("passwordConf", "errros.unmatchPassword");
    }
  }
}
