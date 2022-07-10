package com.isystk.sample.web.front.security;

import com.isystk.sample.domain.entity.User;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.isystk.sample.web.base.filter.UserIdAware;

public class LoginUser extends org.springframework.security.core.userdetails.User implements UserIdAware {

  // ユーザー情報。
  private final User user;

  public LoginUser(User user, List<GrantedAuthority> authorities) {

    super(user.getEmail(), user.getPassword(), true, true, true, true, authorities);

    this.user = user;
  }

  public User User() {
    return user;
  }

  @Override
  public String getUserId() {
    return String.valueOf(this.user.getId());
  }

  @Override
  public String getUserName() {
    return String.valueOf(this.user.getName());
  }

}