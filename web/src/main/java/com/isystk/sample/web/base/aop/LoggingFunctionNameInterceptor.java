package com.isystk.sample.web.base.aop;

import com.isystk.sample.common.Const;
import com.isystk.sample.common.FunctionNameAware;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 機能名をログに出力する
 */
public class LoggingFunctionNameInterceptor extends BaseHandlerInterceptor {

  private static final String MDC_FUNCTION_NAME = Const.MDC_FUNCTION_NAME;
  private static final Logger log = org.slf4j.LoggerFactory
      .getLogger(LoggingFunctionNameInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    // コントローラーの動作前

    val fna = getBean(handler, FunctionNameAware.class);
    if (fna != null) {
      val functionName = fna.getFunctionName();
      MDC.put(MDC_FUNCTION_NAME, functionName);
    }

    return true;
  }
}
