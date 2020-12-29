package com.isystk.sample.web.front.controller.api.v1.member.post;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.helper.UserHelper;
import com.isystk.sample.common.validator.AbstractValidator;
import com.isystk.sample.domain.dao.TPostDao;
import com.isystk.sample.domain.dto.TPostCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * 投稿 入力チェック
 */
@Component
public class MemberPostEditRestValidator extends AbstractValidator<MemberPostEditRestForm> {

  @Autowired
  TPostDao tPostDao;

  @Autowired
  UserHelper userHelper;

  @Override
  protected void doValidate(MemberPostEditRestForm form, Errors errors) {

    // 自分の投稿かどうか
    TPostCriteria criteria = new TPostCriteria();
    criteria.setPostIdEq(form.getPostId());
    criteria.setUserIdEq(userHelper.getLoginUser().getUserId());
    tPostDao.findOne(criteria)
        .orElseThrow(() -> new NoDataFoundException(
            "post_id=" + form.getPostId() + " user_id=" + userHelper.getLoginUser().getUserId()
                + " のデータが見つかりません。"));

  }
}
