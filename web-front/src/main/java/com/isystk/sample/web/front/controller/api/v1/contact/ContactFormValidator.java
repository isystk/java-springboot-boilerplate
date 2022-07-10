package com.isystk.sample.web.front.controller.api.v1.contact;

import com.isystk.sample.common.validator.AbstractValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class ContactFormValidator extends AbstractValidator<ContactForm> {

  @Override
  protected void doValidate(ContactForm form, Errors errors) {
  }
}
