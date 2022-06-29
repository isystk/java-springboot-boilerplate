package com.isystk.sample.web.front.controller.api.v1.entry.remind;

import com.isystk.sample.common.validator.AbstractValidator;
import com.isystk.sample.domain.dao.UserDao;
import com.isystk.sample.domain.dto.UserCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * 会員パスワード変更 入力チェック
 */
@Component
public class EntryRemindRestFormValidator extends AbstractValidator<EntryRemindRestForm> {

  @Autowired
  UserDao userDao;

  @Override
  protected void doValidate(EntryRemindRestForm form, Errors errors) {
    // メールアドレスの存在チェック
    UserCriteria criteria = new UserCriteria();
    criteria.setEmailEq(form.getEmail());
    if (userDao.findOne(criteria).orElse(null) == null) {
      errors.rejectValue("email", "errros.emailNotExist");
    }
  }
}
