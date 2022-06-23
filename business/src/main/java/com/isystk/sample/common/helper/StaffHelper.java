package com.isystk.sample.common.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.domain.dao.AuditInfoHolder;
import com.isystk.sample.domain.dao.AdminsDao;
import com.isystk.sample.domain.dto.AdminsCriteria;
import com.isystk.sample.domain.entity.Admins;

import lombok.extern.slf4j.Slf4j;

/**
 * 管理者ヘルパー
 */
@Component("staff")
@Slf4j
public class StaffHelper {

  @Autowired
  AdminsDao adminsDao;

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
  public Long getLoginStaffId() {
    return getLoginStaff().getId();
  }

  /**
   * ログインユーザーを取得します。
   *
   * @return
   */
  public Admins getLoginStaff() {
    AdminsCriteria criteria = new AdminsCriteria();
    criteria.setEmailEq(AuditInfoHolder.getAuditUser());
    return adminsDao.findOne(criteria).orElseThrow(
        () -> new NoDataFoundException(
            "email=" + AuditInfoHolder.getAuditUser() + "のデータが見つかりません。"));
  }

  /**
   * 最終ログイン日時を更新します。
   *
   * @return
   */
  public void updateLastLogin() {
//    Admins admins = getLoginStaff();
//    admins.setLastLoginTime(DateUtils.getNow());
//    adminsDao.update(admins);
  }

}
