package com.isystk.sample.web.front.controller.html.entry.remind;

import static com.isystk.sample.common.util.ValidateUtils.isNotEquals;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.common.validator.AbstractValidator;

/**
 * 会員パスワード変更 入力チェック
 */
@Component
public class EntryRemindConfigFormValidator extends AbstractValidator<EntryRemindConfigForm> {

	@Override
	protected void doValidate(EntryRemindConfigForm form, Errors errors) {
		// 確認用パスワードと突き合わせる
		if (isNotEquals(form.getPassword(), form.getPasswordConf())) {
			errors.rejectValue("password", "errros.unmatchPassword");
			errors.rejectValue("passwordConf", "errros.unmatchPassword");
		}
	}
}
