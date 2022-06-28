package com.isystk.sample.web.admin.controller.html.stocks.regist;

import com.isystk.sample.common.validator.AbstractValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * 商品 入力チェック
 */
@Component
public class StocksRegistFormValidator extends AbstractValidator<StocksRegistForm> {

  @Override
  protected void doValidate(StocksRegistForm form, Errors errors) {
  }
}
