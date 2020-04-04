package com.isystk.sample.web.front.controller.html.entry;

import static com.isystk.sample.common.util.ValidateUtils.isNotEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.common.validator.AbstractValidator;
import com.isystk.sample.domain.dao.TUserDao;
import com.isystk.sample.domain.dto.TUserCriteria;
import com.isystk.sample.web.base.util.WebValidateUtils;

/**
 * 会員登録 入力チェック
 */
@Component
public class EntryFormValidator extends AbstractValidator<EntryForm> {

	@Autowired
	TUserDao tUserDao;

	@Override
	protected void doValidate(EntryForm form, Errors errors) {
		// 確認用パスワードと突き合わせる
		if (isNotEquals(form.getPassword(), form.getPasswordConf())) {
			errors.rejectValue("password", "errros.unmatchPassword");
			errors.rejectValue("passwordConf", "errros.unmatchPassword");
		}

		// メールアドレスの存在チェック
		TUserCriteria criteria = new TUserCriteria();
		criteria.setEmailEq(form.getEmail());
		if(tUserDao.findOne(criteria).orElse(null) != null) {
			errors.rejectValue("email", "errros.emailExist");
		}
	}
}
