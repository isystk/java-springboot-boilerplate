package com.isystk.sample.web.front.controller.api.v1.entry.remind;

import com.isystk.sample.common.validator.AbstractValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import static com.isystk.sample.common.util.ValidateUtils.isNotEquals;

/**
 * 会員パスワード変更 入力チェック
 */
@Component
public class EntryRemindConfigRestFormValidator extends
    AbstractValidator<EntryRemindConfigRestForm> {

  @Override
  protected void doValidate(EntryRemindConfigRestForm form, Errors errors) {
    // 確認用パスワードと突き合わせる
    if (isNotEquals(form.getPassword(), form.getPasswordConf())) {
      errors.rejectValue("password", "errros.unmatchPassword");
      errors.rejectValue("passwordConf", "errros.unmatchPassword");
    }
  }
}
