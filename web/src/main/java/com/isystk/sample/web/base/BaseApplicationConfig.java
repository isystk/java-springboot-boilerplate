package com.isystk.sample.web.base;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.isystk.sample.web.base.aop.LoggingFunctionNameInterceptor;

public abstract class BaseApplicationConfig
		implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>, WebMvcConfigurer {

	@Override
	public void customize(ConfigurableServletWebServerFactory container) {
	}

	@Bean
	public LoggingFunctionNameInterceptor loggingFunctionNameInterceptor() {
		// MDCに機能名を設定してログに出力する
		return new LoggingFunctionNameInterceptor();
	}

}