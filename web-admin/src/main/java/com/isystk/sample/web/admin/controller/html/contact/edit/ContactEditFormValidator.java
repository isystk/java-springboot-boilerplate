package com.isystk.sample.web.admin.controller.html.contact.edit;

import com.isystk.sample.common.validator.AbstractValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class ContactEditFormValidator extends AbstractValidator<ContactEditForm> {

  @Override
  protected void doValidate(ContactEditForm form, Errors errors) {
  }
}
