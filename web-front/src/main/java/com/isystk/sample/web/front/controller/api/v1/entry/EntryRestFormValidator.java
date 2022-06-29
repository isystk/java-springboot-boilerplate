package com.isystk.sample.web.front.controller.api.v1.entry;

import com.isystk.sample.common.validator.AbstractValidator;
import com.isystk.sample.domain.dao.UserDao;
import com.isystk.sample.domain.dto.UserCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import static com.isystk.sample.common.util.ValidateUtils.isNotEquals;

/**
 * 会員登録 入力チェック
 */
@Component
public class EntryRestFormValidator extends AbstractValidator<EntryRestForm> {

  @Autowired
  UserDao userDao;

  @Override
  protected void doValidate(EntryRestForm form, Errors errors) {
    // 確認用パスワードと突き合わせる
    if (isNotEquals(form.getPassword(), form.getPasswordConf())) {
      errors.rejectValue("password", "errros.unmatchPassword");
      errors.rejectValue("passwordConf", "errros.unmatchPassword");
    }

    // メールアドレスの存在チェック
    UserCriteria criteria = new UserCriteria();
    criteria.setEmailEq(form.getEmail());
    if (userDao.findOne(criteria).orElse(null) != null) {
      errors.rejectValue("email", "errros.emailExist");
    }
  }
}
