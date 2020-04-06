package com.isystk.sample.common.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.domain.dao.AuditInfoHolder;
import com.isystk.sample.domain.dao.TStaffDao;
import com.isystk.sample.domain.dto.TStaffCriteria;
import com.isystk.sample.domain.entity.TStaff;

import lombok.extern.slf4j.Slf4j;

/**
 * 管理者ヘルパー
 */
@Component("staff")
@Slf4j
public class StaffHelper {

	@Autowired
	TStaffDao tStaffDao;

	/**
	 * ログイン済みかどうか
	 */
	public boolean isLogined() {
		return AuditInfoHolder.getAuditUser() != null;
	}

	/**
	 * ログインユーザーを取得します。
	 *
	 * @return
	 */
	public Integer getLoginStaffId() {
		return getLoginStaff().getStaffId();
	}

	/**
	 * ログインユーザーを取得します。
	 *
	 * @return
	 */
	public TStaff getLoginStaff() {
		TStaffCriteria criteria = new TStaffCriteria();
		criteria.setEmailEq(AuditInfoHolder.getAuditUser());
		return tStaffDao.findOne(criteria).orElseThrow(
				() -> new NoDataFoundException("email=" + AuditInfoHolder.getAuditUser() + "のデータが見つかりません。"));
	}

	/**
	 * 最終ログイン日時を更新します。
	 *
	 * @return
	 */
	public void updateLastLogin() {
		TStaff tStaff = getLoginStaff();
		tStaff.setLastLoginTime(DateUtils.getNow());
		tStaffDao.update(tStaff);
	}

}
