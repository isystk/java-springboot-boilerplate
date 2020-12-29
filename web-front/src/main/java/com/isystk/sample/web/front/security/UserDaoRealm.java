package com.isystk.sample.web.front.security;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.isystk.sample.domain.dao.TUserDao;
import com.isystk.sample.domain.dto.TUserCriteria;
import com.isystk.sample.domain.entity.TUser;
import com.isystk.sample.web.base.security.BaseRealm;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * ログインサービス
 */
@Component
@Slf4j
public class UserDaoRealm extends BaseRealm {

  @Autowired
  TUserDao tUserDao;

  @Override
  protected UserDetails getLoginUser(String email) {
    TUser user = null;
    List<GrantedAuthority> authorityList = null;

    try {
      // login_idをメールアドレスと見立てる
      val criteria = new TUserCriteria();
      criteria.setEmailEq(email);

      // 担当者を取得して、セッションに保存する
      user = tUserDao.findOne(criteria)
          .orElseThrow(() -> new UsernameNotFoundException("no user found [id=" + email + "]"));

      // 役割と権限を両方ともGrantedAuthorityとして渡す
      authorityList = AuthorityUtils.createAuthorityList(new HashSet<>().toArray(new String[0]));

      return new LoginUser(user, authorityList);

    } catch (Exception e) {
      if (!(e instanceof UsernameNotFoundException)) {
        // 入力間違い以外の例外はログ出力する
        log.error("failed to getLoginUser. ", e);
        throw e;
      }

      // 0件例外がスローされた場合は何もしない
      // それ以外の例外は、認証エラーの例外で包む
      throw new UsernameNotFoundException("could not select user.", e);
    }
  }
}
