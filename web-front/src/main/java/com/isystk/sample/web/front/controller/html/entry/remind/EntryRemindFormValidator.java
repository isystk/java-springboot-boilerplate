package com.isystk.sample.web.front.controller.html.entry.remind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.common.validator.AbstractValidator;
import com.isystk.sample.domain.dao.TUserDao;
import com.isystk.sample.domain.dto.TUserCriteria;

/**
 * 会員パスワード変更 入力チェック
 */
@Component
public class EntryRemindFormValidator extends AbstractValidator<EntryRemindForm> {

	@Autowired
	TUserDao tUserDao;

	@Override
	protected void doValidate(EntryRemindForm form, Errors errors) {
		// メールアドレスの存在チェック
		TUserCriteria criteria = new TUserCriteria();
		criteria.setEmailEq(form.getEmail());
		if(tUserDao.findOne(criteria).orElse(null) == null) {
			errors.rejectValue("email", "errros.emailNotExist");
		}
	}
}
