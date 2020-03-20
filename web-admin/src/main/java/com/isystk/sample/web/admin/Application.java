package com.isystk.sample.web.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isystk.sample.ComponentScanBasePackage;

@MapperScan("com.isystk.sample.mapper")
@SpringBootApplication(scanBasePackageClasses = { ComponentScanBasePackage.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
