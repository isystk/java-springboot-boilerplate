package com.isystk.sample.web.front.controller.html.member.post;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.domain.validator.AbstractValidator;

/**
 * 投稿 入力チェック
 */
@Component
public class PostHtmlFormValidator extends AbstractValidator<PostHtmlForm> {

	@Override
	protected void doValidate(PostHtmlForm form, Errors errors) {

	}
}
