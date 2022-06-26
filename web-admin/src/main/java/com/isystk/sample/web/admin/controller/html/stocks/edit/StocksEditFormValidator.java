package com.isystk.sample.web.admin.controller.html.stocks.edit;

import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.common.validator.AbstractValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * 商品 入力チェック
 */
@Component
public class StocksEditFormValidator extends AbstractValidator<StocksEditForm> {

  @Autowired
  UserHelper userHelper;

  @Override
  protected void doValidate(StocksEditForm form, Errors errors) {

  }
}
