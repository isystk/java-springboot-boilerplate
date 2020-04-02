package com.isystk.sample.web.base.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;

import com.isystk.sample.common.FunctionNameAware;
import com.isystk.sample.common.Const;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * 機能名をログに出力する
 */
@Slf4j
public class LoggingFunctionNameInterceptor extends BaseHandlerInterceptor {

	private static final String MDC_FUNCTION_NAME = Const.MDC_FUNCTION_NAME;

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
