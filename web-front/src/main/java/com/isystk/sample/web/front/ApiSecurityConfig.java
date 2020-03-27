package com.isystk.sample.web.front;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.isystk.sample.web.base.security.BaseApiSecurityConfig;

@Configuration
@Order(1)
public class ApiSecurityConfig extends BaseApiSecurityConfig {

}
