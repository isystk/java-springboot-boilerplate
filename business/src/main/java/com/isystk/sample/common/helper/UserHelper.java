package com.isystk.sample.common.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.domain.dao.AuditInfoHolder;
import com.isystk.sample.domain.dao.TUserDao;
import com.isystk.sample.domain.dto.TUserCriteria;
import com.isystk.sample.domain.entity.TUser;

import lombok.extern.slf4j.Slf4j;

/**
 * ユーザーヘルパー
 */
@Component
@Slf4j
public class UserHelper {

	@Autowired
	TUserDao tUserDao;

	/**
	 * ユーザーを全件取得します。
	 *
	 * @return
	 */
	public List<TUser> getUserList() {
		TUserCriteria criteria = new TUserCriteria();
		criteria.setDeleteFlgEqual(false);
		return tUserDao.findAll(criteria);
	}

	/**
	 * ログインユーザーを取得します。
	 *
	 * @return
	 */
	public Integer getLoginUserId() {
		return getLoginUser().getUserId();
	}

	/**
	 * ログインユーザーを取得します。
	 *
	 * @return
	 */
	public TUser getLoginUser() {
		TUserCriteria criteria = new TUserCriteria();
		criteria.setEmailEqual(AuditInfoHolder.getAuditUser());
		return tUserDao.findOne(criteria).orElseThrow(
				() -> new NoDataFoundException("email=" + AuditInfoHolder.getAuditUser() + "のデータが見つかりません。"));
	}
}
