package com.isystk.sample.web.admin.controller.html.post;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.domain.validator.AbstractValidator;

/**
 * 投稿 入力チェック
 */
@Component
public class PostFormValidator extends AbstractValidator<PostForm> {

	@Override
	protected void doValidate(PostForm form, Errors errors) {

	}
}
