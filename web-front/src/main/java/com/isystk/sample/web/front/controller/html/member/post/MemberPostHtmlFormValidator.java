package com.isystk.sample.web.front.controller.html.member.post;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.domain.validator.AbstractValidator;

/**
 * 投稿 入力チェック
 */
@Component
public class MemberPostHtmlFormValidator extends AbstractValidator<MemberPostHtmlForm> {

	@Override
	protected void doValidate(MemberPostHtmlForm form, Errors errors) {

	}
}
