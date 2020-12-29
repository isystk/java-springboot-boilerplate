package com.isystk.sample.web.admin.controller.html.post.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.common.validator.AbstractValidator;

/**
 * 投稿 入力チェック
 */
@Component
public class PostEditFormValidator extends AbstractValidator<PostEditForm> {

  @Autowired
  UserHelper userHelper;

  @Override
  protected void doValidate(PostEditForm form, Errors errors) {

  }
}
