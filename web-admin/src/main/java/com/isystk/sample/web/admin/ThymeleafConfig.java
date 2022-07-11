package com.isystk.sample.web.admin;

import com.isystk.sample.web.base.thymeleaf.CustomDialect;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfig  {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
    @Bean
    CustomDialect myDialect() {
        return new CustomDialect();
    }

}