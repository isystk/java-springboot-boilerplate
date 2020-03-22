package com.isystk.sample.web.base.security;

import static com.isystk.sample.web.base.WebConst.*;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import com.isystk.sample.web.base.filter.LoginUserTrackingFilter;

import lombok.val;

/**
 * 基底APIセキュリティコンフィグ
 */
public abstract class BaseApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public FilterRegistrationBean<LoginUserTrackingFilter> loginUserTrackingFilterBean() {
        val filter = new LoginUserTrackingFilter();
        filter.setExcludeUrlPatterns(Arrays.asList(WEBJARS_URL, STATIC_RESOURCES_URL));

        val bean = new FilterRegistrationBean<LoginUserTrackingFilter>(filter);
        bean.setOrder(Ordered.LOWEST_PRECEDENCE);
        return bean;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.antMatcher(API_BASE_URL)
                // すべてのリクエストに認証をかける
                .authorizeRequests().anyRequest().authenticated()
                // Basic認証をかける
                .and().httpBasic().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                // CSRFチェックをしない
                .and().csrf().disable();
    }
}
