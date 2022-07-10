package com.isystk.sample.common.helper;

import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.domain.dao.UserDao;
import com.isystk.sample.domain.dto.UserCriteria;
import com.isystk.sample.domain.entity.User;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.domain.dao.AuditInfoHolder;

import lombok.extern.slf4j.Slf4j;

/**
 * ユーザーヘルパー
 */
@Component
@Slf4j
public class UserHelper {

  @Autowired
  UserDao userDao;

  /**
   * ユーザーを全件取得します。
   *
   * @return
   */
  public List<User> getUserList() {
    UserCriteria criteria = new UserCriteria();
    criteria.setDeleteFlgFalse(true);
    return userDao.findAll(criteria);
  }

  /**
   * ユーザーを取得します。
   *
   * @return
   */
  public User getUser(BigInteger userId) {
    UserCriteria criteria = new UserCriteria();
    criteria.setIdEq(userId);
    return userDao.findOne(criteria).orElseThrow(
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
  public User getUser() {
    UserCriteria criteria = new UserCriteria();
    criteria.setEmailEq(AuditInfoHolder.getAuditUser());
    return userDao.findOne(criteria).orElseThrow(
        () -> new NoDataFoundException(
            "email=" + AuditInfoHolder.getAuditUser() + "のデータが見つかりません。"));
  }

  /**
   * 最終ログイン日時を更新します。
   *
   * @return
   */
  public void updateLastLogin() {
    User user = getUser();
    user.setLastLoginAt(DateUtils.getNow());
    userDao.update(user);
  }

}
