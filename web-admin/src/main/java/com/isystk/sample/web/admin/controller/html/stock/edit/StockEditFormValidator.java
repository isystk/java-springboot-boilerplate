package com.isystk.sample.web.admin.controller.html.stock.edit;

import com.isystk.sample.common.validator.AbstractValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class StockEditFormValidator extends AbstractValidator<StockEditForm> {

  @Override
  protected void doValidate(StockEditForm form, Errors errors) {
  }
}
