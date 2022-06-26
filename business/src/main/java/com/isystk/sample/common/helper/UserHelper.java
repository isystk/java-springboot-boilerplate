package com.isystk.sample.common.helper;

import com.isystk.sample.domain.dto.UsersCriteria;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.domain.dao.AuditInfoHolder;
import com.isystk.sample.domain.dao.UsersDao;
import com.isystk.sample.domain.dto.UsersCriteria;
import com.isystk.sample.domain.entity.Users;

import lombok.extern.slf4j.Slf4j;

/**
 * ユーザーヘルパー
 */
@Component
@Slf4j
public class UserHelper {

  @Autowired
  UsersDao usersDao;

  /**
   * ユーザーを全件取得します。
   *
   * @return
   */
  public List<Users> getUserList() {
    UsersCriteria criteria = new UsersCriteria();
    criteria.setDeleteFlgFalse(true);
    return usersDao.findAll(criteria);
  }

  /**
   * ユーザーを取得します。
   *
   * @return
   */
  public Users getUser(BigInteger userId) {
    UsersCriteria criteria = new UsersCriteria();
    criteria.setIdEq(userId);
    return usersDao.findOne(criteria).orElseThrow(
        () -> new NoDataFoundException("userId=" + userId + "のデータが見つかりません。"));
  }

  /**
   * ログインユーザーを取得します。
   *
   * @return
   */
  public BigInteger getLoginUserId() {
    return getUser().getId();
  }

  /**
   * ログインユーザーを取得します。
   *
   * @return
   */
  public Users getUser() {
    UsersCriteria criteria = new UsersCriteria();
    criteria.setEmailEq(AuditInfoHolder.getAuditUser());
    return usersDao.findOne(criteria).orElseThrow(
        () -> new NoDataFoundException(
            "email=" + AuditInfoHolder.getAuditUser() + "のデータが見つかりません。"));
  }

  /**
   * 最終ログイン日時を更新します。
   *
   * @return
   */
  public void updateLastLogin() {
//    Users users = getUser();
//    users.setLastLoginTime(DateUtils.getNow());
//    usersDao.update(users);
  }

}
