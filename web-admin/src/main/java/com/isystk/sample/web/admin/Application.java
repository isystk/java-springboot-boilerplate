package com.isystk.sample.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isystk.sample.ComponentScanBasePackage;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanBasePackage.class})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
