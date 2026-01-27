package com.bootcamp.demo.demo_weather.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_weather.entity.WeatherEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Repository
public interface WeatherForecastRepository extends JpaRepository<WeatherEntity, Long> {
  List<WeatherEntity> findByDataUpdateTime(LocalDateTime dataUpdateTime);

  List<WeatherEntity> findByForecastDate(LocalDate forecastDate);

  List<WeatherEntity> findByForecastDateBetween(LocalDate start, LocalDate end);

  // JPQL (Java Persistence Query Language)
  // SELECT entity
  // @Query(value = "SELECT e FROM WeatherEntity e WHERE e.maxTemp >= :degree")
  // List<WeatherEntity> findByMaxTempJPQL(String degree);
  @Query("SELECT w FROM WeatherEntity w WHERE w.forecastDate BETWEEN :start AND :end")
  List<WeatherEntity> findWeatherByDateRange(@Param("start") LocalDate startDate, @Param("end") LocalDate endDate);
  
  // Native SQL
  // (Not recommend to use * in native SQL)
  // @Query(value = "SELECT * FROM weather_forecasts WHERE min_temp >= :degree", nativeQuery = true)
  // List<WeatherEntity> findByMinTempJPQL(String degree);
  @Query(value = """
    SELECT 
        id,
        forecast_date,
        week,
        forecast_wind,
        forecast_weather,
        max_temp,
        min_temp,
        max_humidity,
        min_humidity,
        forecast_icon,
        psr,
        data_update_time
    FROM weather_forecasts 
    WHERE forecast_date BETWEEN :start AND :end
    """, 
    nativeQuery = true)
  List<WeatherEntity> findWeatherByDateRangeNative(@Param("start") LocalDate startDate, @Param("end") LocalDate endDate);


  
}
