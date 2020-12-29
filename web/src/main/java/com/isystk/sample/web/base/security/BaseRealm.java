package com.isystk.sample.web.base.security;

import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 基底レルム
 */
public abstract class BaseRealm implements UserDetailsService {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(BaseRealm.class);

  @Override
  public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
    UserDetails user = null;

    try {
      user = getLoginUser(loginId);
    } catch (Throwable e) {
      throw new UsernameNotFoundException("failed to find login user.");
    }

    if (user == null) {
      throw new UsernameNotFoundException("no user found. [login_id=" + loginId + "]");
    }

    return user;
  }

  protected abstract UserDetails getLoginUser(String loginId);
}
