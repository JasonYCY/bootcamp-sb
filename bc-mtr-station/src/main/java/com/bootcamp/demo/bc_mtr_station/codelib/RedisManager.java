package com.bootcamp.demo.bc_mtr_station.codelib;

import java.time.Duration;
import java.util.Optional;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class RedisManager {
  private RedisTemplate<String, String> redisTemplate;
  private ObjectMapper objectMapper;


  public RedisManager(ObjectMapper objectMapper, RedisConnectionFactory factory) {
    // 0. Create new RedisTemplate object
    redisTemplate = new RedisTemplate<>();
    
    // 1. Connects to Redis
    redisTemplate.setConnectionFactory(factory); // 'factory' is auto-injected by Spring
    
    // 2. Configures how keys are serialized
    redisTemplate.setKeySerializer(RedisSerializer.string()); // Keys will be stored as UTF-8 strings
    
    // 3. Configures how values are serialized
    redisTemplate.setValueSerializer(RedisSerializer.json()); // Values will be JSON objects (not plain text)

    // 4. Forces initialization now
    redisTemplate.afterPropertiesSet();

    // 5. Initialize objectMapper
    this.objectMapper = objectMapper;
  }


  /**
   * Retrieves and deserializes an object from Redis using the specified key.
   *
   * @param <T>       the type of the value to be returned
   * @param key       the Redis key to look up
   * @param valueType the class type to which the JSON string should be mapped
   * @return an {@link Optional} containing the deserialized object, 
   *         or an empty Optional if the key does not exist
   * @throws RuntimeException if the stored value cannot be deserialized to the target type
   */
  public <T> Optional<T> get(String key, Class<T> valueType) {
    String value = redisTemplate.opsForValue().get(key);
    if (value == null) return Optional.empty();

    return Optional.of(objectMapper.readValue(value, valueType));
  }

  /**
   * Serializes the given object to a JSON string and stores it in Redis 
   * with a specified expiration timeout.
   * 
   * @param <T>     The type of the value being stored
   * @param key     The Redis key under which the value will be stored
   * @param value   The object to be serialized and stored
   * @param timeout The duration after which the key should expire
   * @throws RuntimeException if serialization fails (depending on your mapper config)
   */
  public <T> void set(String key, T value, Duration timeout) {
    String serializedValue = objectMapper.writeValueAsString(value);
    redisTemplate.opsForValue().set(key, serializedValue, timeout);
  }



}
