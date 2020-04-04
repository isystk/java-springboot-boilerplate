package com.isystk.sample.web.front.controller.html.member.post.edit;

import static com.isystk.sample.common.util.ValidateUtils.isNotEquals;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.common.validator.AbstractValidator;
import com.isystk.sample.domain.dao.TPostDao;
import com.isystk.sample.domain.dao.TUserDao;
import com.isystk.sample.domain.dto.TPostCriteria;
import com.isystk.sample.domain.dto.TUserCriteria;

/**
 * 投稿 入力チェック
 */
@Component
public class MemberPostEditFormValidator extends AbstractValidator<MemberPostEditForm> {

	@Autowired
	TPostDao tPostDao;

	@Autowired
	UserHelper userHelper;

	@Override
	protected void doValidate(MemberPostEditForm form, Errors errors) {

		// 自分の投稿かどうか
		TPostCriteria criteria = new TPostCriteria();
		criteria.setPostIdEq(form.getPostId());
		criteria.setUserIdEq(userHelper.getLoginUser().getUserId());
		tPostDao.findOne(criteria)
				.orElseThrow(() -> new NoDataFoundException("post_id=" + form.getPostId() + " user_id=" + userHelper.getLoginUser().getUserId() + " のデータが見つかりません。"));

	}
}
