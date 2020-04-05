package com.isystk.sample.web.base.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import lombok.Setter;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

import static com.isystk.sample.common.Const.ERROR_URL;

/**
 * リクエストパラメーターの文字数が想定外に多い場合はエラー画面に遷移させる
 */
@Slf4j
public class CheckOverflowFilter extends OncePerRequestFilter {

    @Setter
    private int maxLength = 20000;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            val parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                val parameterName = parameterNames.nextElement();
                val value = request.getParameter(parameterName);

                if (value != null && value.length() > maxLength) {
                    redirectToErrorPage(request, response);
                    return;
                }
            }
        } catch (Exception e) {
            log.error("cloud not parse request parameters", e);
            redirectToErrorPage(request, response);
        }

        filterChain.doFilter(request, response);
    }

    private void redirectToErrorPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        val contextPath = request.getContextPath();
        response.sendRedirect(contextPath + ERROR_URL);
    }
}
