package com.isystk.sample.web.admin.controller.html.stocks;

import com.isystk.sample.common.validator.AbstractValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * 投稿 入力チェック
 */
@Component
public class StocksListFormValidator extends AbstractValidator<StocksListForm> {

  @Override
  protected void doValidate(StocksListForm form, Errors errors) {

  }
}
