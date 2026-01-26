package com.bootcamp.demo.demo_weather.repository;

import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_weather.entity.WeatherEntity;

@Repository
public interface WeatherForecastRepository extends JpaRepository<WeatherEntity, Long> {
  List<WeatherEntity> findByDataUpdateTime(OffsetDateTime dataUpdateTime);
  
}
