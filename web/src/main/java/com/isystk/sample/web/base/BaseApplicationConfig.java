package com.isystk.sample.web.base;

import static com.isystk.sample.common.Const.*;

import java.util.Arrays;

import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.isystk.sample.common.dto.DefaultPageFactoryImpl;
import com.isystk.sample.common.dto.PageFactory;
import com.isystk.sample.web.base.aop.LoggingFunctionNameInterceptor;
import com.isystk.sample.web.base.aop.RequestTrackingInterceptor;
import com.isystk.sample.web.base.aop.SetAuditInfoInterceptor;
import com.isystk.sample.web.base.aop.SetDoubleSubmitCheckTokenInterceptor;
import com.isystk.sample.web.base.aop.SetModelAndViewInterceptor;
import com.isystk.sample.web.base.controller.api.resource.DefaultResourceFactoryImpl;
import com.isystk.sample.web.base.controller.api.resource.ResourceFactory;
import com.isystk.sample.web.base.filter.LoginUserTrackingFilter;

import lombok.val;
import nz.net.ultraq.thymeleaf.LayoutDialect;

public abstract class BaseApplicationConfig
		implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>, WebMvcConfigurer {

	@Override
	public void customize(ConfigurableServletWebServerFactory container) {
	}

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        // コントローラーを追加する
//        registry.addViewController(FORBIDDEN_URL).setViewName(FORBIDDEN_VIEW);
//        registry.addViewController(ERROR_URL).setViewName(ERROR_VIEW);
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new LocalDateConverter(LOCALDATE_FORMAT));
//        registry.addConverter(new LocalDateTimeConverter(LOCALDATETIME_FORMAT));
//    }
//
//    @Bean
//    public ForwardedHeaderFilter forwardedHeaderFilter() {
//        // X-Forwarded-XXXの値を使ってリクエスト情報を上書きする
//        return new ForwardedHeaderFilter();
//    }
//
//    @Bean
//    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
//        // hiddenパラメータで指定されたHTTPメソッドに変換する
//        return new HiddenHttpMethodFilter();
//    }
//
//    @Bean
//    public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
//        // ETagの制御を行う
//        return new ShallowEtagHeaderFilter();
//    }
//
//    @Bean
//    public FilterRegistrationBean<CorsFilter> corsFilter() {
//        val config = new CorsConfiguration();
//        config.setAllowCredentials(allowCredentials);
//        config.setAllowedHeaders(allowedHeaders);
//        config.setAllowedOrigins(corsAllowedOrigins);
//        config.setAllowedMethods(allowedMethods);
//        config.setMaxAge(maxAge);
//
//        val source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//
//        val bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
//        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return bean;
//    }

    @Bean
    public FilterRegistrationBean<LoginUserTrackingFilter> loginUserTrackingFilterBean() {
        val filter = new LoginUserTrackingFilter();
        filter.setExcludeUrlPatterns(Arrays.asList(WEBJARS_URL, STATIC_RESOURCES_URL));

        val bean = new FilterRegistrationBean<LoginUserTrackingFilter>(filter);
        bean.setOrder(Ordered.LOWEST_PRECEDENCE);
        return bean;
    }

//    @Bean
//    public FilterRegistrationBean<ClearMDCFilter> clearMDCFilterBean() {
//        val filter = new ClearMDCFilter();
//        val bean = new FilterRegistrationBean<ClearMDCFilter>(filter);
//        bean.setOrder(Ordered.LOWEST_PRECEDENCE);
//        return bean;
//    }
//
//    @Bean
//    public FilterRegistrationBean<CheckOverflowFilter> checkOverflowFilterBean() {
//        val filter = new CheckOverflowFilter();
//        val bean = new FilterRegistrationBean<CheckOverflowFilter>(filter);
//        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return bean;
//    }

//    @Bean
//    public LocaleResolver localeResolver() {
//        // Cookieに言語を保存する
//        val resolver = new CookieLocaleResolver();
//        resolver.setCookieName("lang");
//        return resolver;
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        // langパラメータでロケールを切り替える
//        val interceptor = new LocaleChangeInterceptor();
//        interceptor.setParamName("lang");
//        return interceptor;
//    }

//    @Bean
//    public LocalValidatorFactoryBean beanValidator(MessageSource messageSource) {
//        val bean = new LocalValidatorFactoryBean();
//        bean.setValidationMessageSource(messageSource);
//        return bean;
//    }
//
//    @Bean
//    public LayoutDialect layoutDialect() {
//        return new LayoutDialect();
//    }

//    @Bean
//    public CacheManager cacheManager() {
//        val manager = new EhCacheCacheManager();
//        manager.setCacheManager(ehcache().getObject());
//        return manager;
//    }
//
//    @Bean
//    public EhCacheManagerFactoryBean ehcache() {
//        val ehcache = new EhCacheManagerFactoryBean();
//        ehcache.setConfigLocation(new ClassPathResource("ehcache.xml"));
//        return ehcache;
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // webjarsをResourceHandlerに登録する
        registry.addResourceHandler(WEBJARS_URL)
                // JARの中身をリソースロケーションにする
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
                // webjars-locatorを使うためにリソースチェイン内のキャッシュを無効化する
                .resourceChain(false);
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
    public SetAuditInfoInterceptor setAuditInfoInterceptor() {
        // システム制御項目を保存してDB保存時に利用する
        return new SetAuditInfoInterceptor();
    }

    @Bean
    public SetDoubleSubmitCheckTokenInterceptor setDoubleSubmitCheckTokenInterceptor() {
        // 二重送信をチェックする
        return new SetDoubleSubmitCheckTokenInterceptor();
    }

    @Bean
    public SetModelAndViewInterceptor setModelAndViewInterceptor() {
        // 共通的な定数定義などを画面変数に設定する
        return new SetModelAndViewInterceptor();
    }

//    @Bean
//    public PermissionKeyResolver permissionKeyResolver() {
//        // コントローラー・メソッド名から権限キーを解決する
//        return new DefaultPermissionKeyResolver();
//    }
//
//    @Bean
//    public AuthorizationInterceptor authorizationInterceptor() {
//        // ログインユーザーの操作を認可する
//        return new AuthorizationInterceptor();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
        registry.addInterceptor(requestTrackingInterceptor());
        registry.addInterceptor(loggingFunctionNameInterceptor());
        registry.addInterceptor(setAuditInfoInterceptor());
        registry.addInterceptor(setDoubleSubmitCheckTokenInterceptor());
        registry.addInterceptor(setModelAndViewInterceptor());
//        registry.addInterceptor(authorizationInterceptor());
    }
//
//    @Bean
//    public SnakeToLowerCamelCaseModelAttributeMethodProcessor attributeMethodProcessor() {
//        // login_id パラメータを loginId にマッピングする
//        return new SnakeToLowerCamelCaseModelAttributeMethodProcessor(true);
//    }
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(attributeMethodProcessor());
//    }

    @Bean
    public PageFactory pageFactory() {
        return new DefaultPageFactoryImpl();
    }

    @Bean
    public ResourceFactory resourceFactory() {
        return new DefaultResourceFactoryImpl();
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