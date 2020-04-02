package com.isystk.sample.web.base.filter;

import static com.isystk.sample.common.Const.MDC_LOGIN_USER_ID;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.Setter;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * ログインIDをMDCに設定する
 */
@Slf4j
public class LoginUserTrackingFilter extends OncePerRequestFilter {

	@Setter
	List<String> excludeUrlPatterns;

	private static final AntPathMatcher pathMatcher = new AntPathMatcher();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		try {
			if (!shouldNotFilter(request)) {
				MDC.put(MDC_LOGIN_USER_ID, "GUEST");
				getUserId().ifPresent(userId -> MDC.put(MDC_LOGIN_USER_ID, userId));
			}
		} finally {
			filterChain.doFilter(request, response);
		}
	}

	protected Optional<String> getUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null) {
			Object principal = authentication.getPrincipal();

			if (principal instanceof UserIdAware) {
				val loginId = ((UserIdAware) principal).getUserId();
				return Optional.of(loginId);
			}
		}

		return Optional.empty();
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		val exclude = excludeUrlPatterns.stream().anyMatch(p -> pathMatcher.match(p, request.getServletPath()));

		if (exclude) {
			return true;
		}

		return false;
	}
}
