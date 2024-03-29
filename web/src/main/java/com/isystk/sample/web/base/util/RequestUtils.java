package com.isystk.sample.web.base.util;

import javax.servlet.http.HttpServletResponse;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

  public static final String X_REQUESTED_WITH = "X-Requested-With";

  public static final String XMLHTTP_REQUEST = "XMLHttpRequest";

  /**
   * User-Agentを取得します。
   *
   * @param request
   * @return
   */
  public static String getUserAgent(HttpServletRequest request) {
    return StringUtils.trimToEmpty(request.getHeader(HttpHeaders.USER_AGENT));
  }

  /**
   * Ajax通信であるかを示す値を返します。
   *
   * @param request
   * @return
   */
  public static boolean isAjaxRequest(HttpServletRequest request) {
    val header = request.getHeader(X_REQUESTED_WITH);
    val isAjax = StringUtils.equalsIgnoreCase(XMLHTTP_REQUEST, header);
    return isAjax;
  }

  /**
   * HttpServletRequestを返します。
   *
   * @return
   */
  public static HttpServletRequest getRequest() {
    val attributes = RequestContextHolder.getRequestAttributes();
    return ((ServletRequestAttributes) attributes).getRequest();
  }

  /**
   * HttpServletRequestを返します。
   *
   * @return
   */
  public static HttpServletResponse getResponse() {
    val attributes = RequestContextHolder.getRequestAttributes();
    return ((ServletRequestAttributes) attributes).getResponse();
  }

  /**
   * サイトURLを返します。
   *
   * @return
   */
  public static String getSiteUrl() {
    val servletRequest = getRequest();

    String scheme = servletRequest.getScheme();
    String host = servletRequest.getRemoteHost();
    int port = servletRequest.getServerPort();
    String path = servletRequest.getContextPath();

    String siteUrl = null;
    if (port == 80 || port == 443) {
      siteUrl = StringUtils.join(scheme, "://", host, path);
    } else {
      siteUrl = StringUtils.join(scheme, "://", host, ":", String.valueOf(port), path);
    }

    return siteUrl;
  }
}
