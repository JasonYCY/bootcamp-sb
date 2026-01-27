package com.bootcamp.demo.demo_weather.mapper;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_weather.entity.WeatherEntity;
import com.bootcamp.demo.demo_weather.model.dto.WeatherForecastDTO;

@Component
public class EntityMapper {
  public WeatherEntity toWeatherEntity(WeatherForecastDTO weatherForecastDTO, LocalDateTime updateTime) {
    return WeatherEntity.builder()
      .forecastDate(weatherForecastDTO.getForecastDate())
      .week(weatherForecastDTO.getWeek())
      .forecastWind(weatherForecastDTO.getForecastWind())
      .forecastWeather(weatherForecastDTO.getForecastWeather())
      .maxTemp(weatherForecastDTO.getForecastMaxTemp().toString())
      .minTemp(weatherForecastDTO.getForecastMinTemp().toString())
      .maxHumidity(weatherForecastDTO.getForecastMaxRh().toString())
      .minHumidity(weatherForecastDTO.getForecastMinRh().toString())
      .forecastIcon(weatherForecastDTO.getForecastIcon())
      .psr(weatherForecastDTO.getPsr())
      .dataUpdateTime(updateTime)
      .build();
  }



}
