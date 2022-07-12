package com.isystk.sample.web.front;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
//        // パッケージを指定して表示するAPIを絞り込む
//        .apis(RequestHandlerSelectors.basePackage("com.isystk.sample.web.front.controller.api.v1"))
//        .paths(PathSelectors.any())
        // パスを指定して絞り込むこともできる
        .paths(PathSelectors.ant("/api/v1/**"))
        .build()
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        // タイトル
        .title("LaraEC API")
        // 詳細な説明
        .description("LaraECで利用されているAPIの一覧です")
        // バージョン
        .version("1.0.0")
        // 連絡先
        .contact(new Contact("isystk", "https://profile.isystk.com", "iseyoshitaka@isystk.com"))
        // ライセンス名
        .license("isystk")
        // ライセンスURL
        .licenseUrl("https://github.com/isystk/java-springboot-boilerplate/blob/master/LICENSE")
//        // 利用規約のURL
//        .termsOfServiceUrl("http://example.com/termsofuse")
        .build();
  }
}