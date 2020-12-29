package com.isystk.sample.web.base.aop;

import com.isystk.sample.domain.dao.DoubleSubmitCheckTokenHolder;
import com.isystk.sample.web.base.security.DoubleSubmitCheckToken;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 二重送信防止チェックのトークンをセッションに設定する
 */
public class SetDoubleSubmitCheckTokenInterceptor extends BaseHandlerInterceptor {

  private static final Logger log = org.slf4j.LoggerFactory
      .getLogger(SetDoubleSubmitCheckTokenInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    // コントローラーの動作前
    val expected = DoubleSubmitCheckToken.getExpectedToken(request);
    val actual = DoubleSubmitCheckToken.getActualToken(request);
    DoubleSubmitCheckTokenHolder.set(expected, actual);
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    // コントローラーの動作後
    if (StringUtils.equalsIgnoreCase(request.getMethod(), "POST")) {
      // POSTされたときにトークンが一致していれば新たなトークンを発行する
      val expected = DoubleSubmitCheckToken.getExpectedToken(request);
      val actual = DoubleSubmitCheckToken.getActualToken(request);

      if (expected != null && actual != null && Objects.equals(expected, actual)) {
        DoubleSubmitCheckToken.renewToken(request);
      }
    }
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex)
      throws Exception {
    // 処理完了後
    DoubleSubmitCheckTokenHolder.clear();
  }
}
