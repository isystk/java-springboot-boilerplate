package com.isystk.sample.web.front.controller.html.member.post;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.common.validator.AbstractValidator;

/**
 * 投稿 入力チェック
 */
@Component
public class MemberPostFormValidator extends AbstractValidator<MemberPostForm> {

	@Override
	protected void doValidate(MemberPostForm form, Errors errors) {

	}
}
