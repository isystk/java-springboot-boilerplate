package com.isystk.sample.common.helper;

import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.domain.dao.AdminDao;
import com.isystk.sample.domain.dto.AdminCriteria;
import com.isystk.sample.domain.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.domain.dao.AuditInfoHolder;

import lombok.extern.slf4j.Slf4j;

/**
 * 管理者ヘルパー
 */
@Component("staff")
@Slf4j
public class StaffHelper {

  @Autowired
  AdminDao adminDao;

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
  public Admin getLoginStaff() {
    AdminCriteria criteria = new AdminCriteria();
    criteria.setEmailEq(AuditInfoHolder.getAuditUser());
    return adminDao.findOne(criteria).orElseThrow(
        () -> new NoDataFoundException(
            "email=" + AuditInfoHolder.getAuditUser() + "のデータが見つかりません。"));
  }

  /**
   * 最終ログイン日時を更新します。
   *
   * @return
   */
  public void updateLastLogin() {
    Admin admin = getLoginStaff();
    admin.setLastLoginAt(DateUtils.getNow());
    adminDao.update(admin);
  }

}
