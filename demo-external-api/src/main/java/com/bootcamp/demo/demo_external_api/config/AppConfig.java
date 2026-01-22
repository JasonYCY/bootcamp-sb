package com.bootcamp.demo.demo_external_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_external_api.model.Cat;

// @Configuration + @Bean is for creating bean for external library
@Configuration
public class AppConfig {
  @Bean
  RestTemplate RestTemplate() {
    return new RestTemplate();
  }

  // If there are more than 1 Bean with same type
  @Bean
  Cat superCat() {
    return new Cat("JDK", 99);
  }

  @Bean
  Cat smallCat() {
    return new Cat("123", 100);
  }


}
