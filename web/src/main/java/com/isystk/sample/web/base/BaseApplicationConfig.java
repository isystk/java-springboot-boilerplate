package com.isystk.sample.web.base;

import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.isystk.sample.common.dto.DefaultPageFactoryImpl;
import com.isystk.sample.common.dto.PageFactory;
import com.isystk.sample.web.base.aop.LoggingFunctionNameInterceptor;
import com.isystk.sample.web.base.aop.RequestTrackingInterceptor;
import com.isystk.sample.web.base.aop.SetAuditInfoInterceptor;
import com.isystk.sample.web.base.aop.SetDoubleSubmitCheckTokenInterceptor;
import com.isystk.sample.web.base.aop.SetModelAndViewInterceptor;
import com.isystk.sample.web.base.controller.api.resource.DefaultResourceFactoryImpl;
import com.isystk.sample.web.base.controller.api.resource.ResourceFactory;

import lombok.val;

public abstract class BaseApplicationConfig
		implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>, WebMvcConfigurer {

	@Override
	public void customize(ConfigurableServletWebServerFactory container) {
	}

	@Bean
	public PageFactory pageFactory() {
		return new DefaultPageFactoryImpl();
	}

	@Bean
	public ResourceFactory resourceFactory() {
		return new DefaultResourceFactoryImpl();
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		// langパラメータでロケールを切り替える
		val interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	@Bean
	public RequestTrackingInterceptor requestTrackingInterceptor() {
		// MDCにIDを設定してリクエストをトラッキングする
		return new RequestTrackingInterceptor();
	}

	@Bean
	public LoggingFunctionNameInterceptor loggingFunctionNameInterceptor() {
		// MDCに機能名を設定してログに出力する
		return new LoggingFunctionNameInterceptor();
	}

	@Bean
	public SetDoubleSubmitCheckTokenInterceptor setDoubleSubmitCheckTokenInterceptor() {
		// 二重送信をチェックする
		return new SetDoubleSubmitCheckTokenInterceptor();
	}

	@Bean
	public SetAuditInfoInterceptor setAuditInfoInterceptor() {
		// システム制御項目を保存してDB保存時に利用する
		return new SetAuditInfoInterceptor();
	}

	@Bean
	public SetModelAndViewInterceptor setModelAndViewInterceptor() {
		// 共通的な定数定義などを画面変数に設定する
		return new SetModelAndViewInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
		registry.addInterceptor(requestTrackingInterceptor());
		registry.addInterceptor(loggingFunctionNameInterceptor());
		registry.addInterceptor(setAuditInfoInterceptor());
		registry.addInterceptor(setDoubleSubmitCheckTokenInterceptor());
		registry.addInterceptor(setModelAndViewInterceptor());
	}

	/**
	 * [] を含むURLをGETしようとするとTomcatが400を返す 問題に対応
	 * 
	 * @return
	 */
	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> containerCustomizer() {
		return new EmbeddedTomcatCustomizer();
	}

	private static class EmbeddedTomcatCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
		@Override
		public void customize(TomcatServletWebServerFactory factory) {
			factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
				connector.setAttribute("relaxedPathChars", "<>[\\]^`{|}");
				connector.setAttribute("relaxedQueryChars", "<>[\\]^`{|}");
			});
		}
	}
}