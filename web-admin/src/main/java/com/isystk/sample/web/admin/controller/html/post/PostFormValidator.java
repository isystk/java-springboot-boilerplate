package com.isystk.sample.web.admin.controller.html.post;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.common.validator.AbstractValidator;

/**
 * 投稿 入力チェック
 */
@Component
public class PostFormValidator extends AbstractValidator<PostSearchForm> {

	@Override
	protected void doValidate(PostSearchForm form, Errors errors) {

	}
}
