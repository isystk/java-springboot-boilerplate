package com.isystk.sample.web.admin.controller.html.post.regist;

import static com.isystk.sample.common.util.ValidateUtils.isNotEquals;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.common.validator.AbstractValidator;

/**
 * 投稿 入力チェック
 */
@Component
public class PostRigstFormValidator extends AbstractValidator<PostRegistForm> {

	@Override
	protected void doValidate(PostRegistForm form, Errors errors) {

	}
}
