package com.isystk.sample.web.admin.controller.html.stock.regist;

import com.isystk.sample.common.validator.AbstractValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class StockRegistFormValidator extends AbstractValidator<StockRegistForm> {

  @Override
  protected void doValidate(StockRegistForm form, Errors errors) {
  }
}
