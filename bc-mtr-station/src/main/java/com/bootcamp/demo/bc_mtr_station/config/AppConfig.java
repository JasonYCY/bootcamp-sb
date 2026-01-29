package com.bootcamp.demo.bc_mtr_station.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    
    // 1. Connects to Redis
    redisTemplate.setConnectionFactory(factory); // 'factory' is auto-injected by Spring
    
    // 2. Configures how keys are serialized
    redisTemplate.setKeySerializer(RedisSerializer.string()); // Keys will be stored as UTF-8 strings
    
    // 3. Configures how values are serialized
    redisTemplate.setValueSerializer(RedisSerializer.json()); // Values will be JSON objects (not plain text)

    // 4. Forces initialization now
    redisTemplate.afterPropertiesSet();

    return redisTemplate;
  }



}
