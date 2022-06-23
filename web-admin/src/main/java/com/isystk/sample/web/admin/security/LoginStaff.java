package com.isystk.sample.web.admin.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.isystk.sample.domain.entity.Admins;
import com.isystk.sample.web.base.filter.UserIdAware;

public class LoginStaff extends User implements UserIdAware {

  // 管理者情報。
  private final Admins staff;

  public LoginStaff(Admins staff, List<GrantedAuthority> authorities) {

    super(staff.getEmail(), staff.getPassword(), true, true, true, true, authorities);

    this.staff = staff;
  }

  public Admins Staff() {
    return staff;
  }

  @Override
  public String getUserId() {
    return String.valueOf(this.staff.getId());
  }

  @Override
  public String getUserName() {
    return String.valueOf(this.staff.getName());
  }

}