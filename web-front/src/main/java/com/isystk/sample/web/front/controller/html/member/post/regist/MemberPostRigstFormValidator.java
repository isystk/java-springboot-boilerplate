package com.isystk.sample.web.front.controller.html.member.post.regist;

import static com.isystk.sample.common.util.ValidateUtils.isNotEquals;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.common.validator.AbstractValidator;

/**
 * 投稿 入力チェック
 */
@Component
public class MemberPostRigstFormValidator extends AbstractValidator<MemberPostRegistForm> {

	@Override
	protected void doValidate(MemberPostRegistForm form, Errors errors) {

	}
}
