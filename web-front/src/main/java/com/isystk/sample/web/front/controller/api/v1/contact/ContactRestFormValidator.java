package com.isystk.sample.web.front.controller.api.v1.contact;

import com.isystk.sample.common.validator.AbstractValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class ContactRestFormValidator extends AbstractValidator<ContactRestForm> {

  @Override
  protected void doValidate(ContactRestForm form, Errors errors) {
  }
}
