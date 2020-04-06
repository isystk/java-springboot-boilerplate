package com.isystk.sample.web.front.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.isystk.sample.domain.entity.TUser;
import com.isystk.sample.web.base.filter.UserIdAware;

public class LoginUser extends User implements UserIdAware {

	// ユーザー情報。
	private final TUser user;

	public LoginUser(TUser user, List<GrantedAuthority> authorities) {

		super(user.getEmail(), user.getPassword(), true, true, true, true, authorities);

		this.user = user;
	}

	public TUser User() {
		return user;
	}

	@Override
	public String getUserId() {
		return String.valueOf(this.user.getUserId());
	}

	@Override
	public String getUserName() {
		return String.valueOf(this.user.getFamilyName()) + " " + String.valueOf(this.user.getName());
	}

}