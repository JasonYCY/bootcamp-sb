package com.bootcamp.demo.demo_external_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// @Configuration + @Bean is for creating bean for external library
@Configuration
public class AppConfig {
  @Bean
  RestTemplate RestTemplate() {
    return new RestTemplate();
  }
  
}
