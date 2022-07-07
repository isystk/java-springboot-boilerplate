package com.isystk.sample.web.base.util;

import com.isystk.sample.common.util.NumberUtils;
import javax.servlet.http.Cookie;

public class CookieUtils {

  /**
   * クッキーを取得します。(文字列)
   *
   * @param name 保存名
   * @return Cookie
   */
  public static String getValue(String name) {
    if (name == null || RequestUtils.getRequest() == null) {
      throw new IllegalArgumentException();
    }
    if (RequestUtils.getRequest().getCookies() == null) {
      return null;
    }
    for (Cookie cookie : RequestUtils.getRequest().getCookies()) {
      if (name.equals(cookie.getName())) {
        return cookie.getValue();
      }
    }
    return null;
  }

  /**
   * クッキーを取得します。(数値)
   *
   * @param name 保存名
   * @return Cookie
   */
  public static Integer getValueInteger(String name) {
    String value = getValue(name);

    Integer result = null;
    if (value != null) {
      result = NumberUtils.toInteger(value);
    }

    return result;
  }

  /**
   * クッキーを保存します。
   *
   * @param name 保存名
   * @param value 値
   */
  public static void setValue(String name, String value) {
    Cookie cookie = new Cookie(name, value);
    cookie.setMaxAge(30);
    cookie.setPath("/");
    cookie.setSecure(true);
    RequestUtils.getResponse().addCookie(cookie);
  }

  /**
   * クッキーを保存します。(内容は細かく指定可能)
   *
   * @param key Cookie 名
   * @param value 値
   * @param path パス
   * @param maxAge 寿命
   * @param domainName ドメイン名
   */
  public static void setCookie(String key, String value, String path, int maxAge, String domainName) {
    Cookie cookie = new Cookie(key, value);
    if (domainName != null) {
      cookie.setDomain(domainName);
    }
    cookie.setMaxAge(maxAge);
    cookie.setSecure(true);
    cookie.setPath(path);

    RequestUtils.getResponse().addCookie(cookie);
  }

  /**
   * クッキーを削除します
   *
   * @param key Cookie名
   */
  public static void removeCookie(String key) {
    if (key == null || RequestUtils.getRequest() == null) {
      throw new IllegalArgumentException();
    }
    if (RequestUtils.getRequest().getCookies() == null) {
      return;
    }
    for (Cookie cookie : RequestUtils.getRequest().getCookies()) {
      if (key.equals(cookie.getName())) {
        Cookie targetCookie = new Cookie(key, null);
        targetCookie.setMaxAge(0);
        targetCookie.setPath("/");
        RequestUtils.getResponse().addCookie(targetCookie);
        return;
      }
    }
  }

}
