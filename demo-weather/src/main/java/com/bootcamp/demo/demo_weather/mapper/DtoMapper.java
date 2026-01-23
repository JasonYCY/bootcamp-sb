package com.bootcamp.demo.demo_weather.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_weather.dto.WeatherDto;
import com.bootcamp.demo.demo_weather.mapper.formatter.DateFormatter;
import com.bootcamp.demo.demo_weather.model.dto.WeatherForecastDTO;

@Component
public class DtoMapper {
  @Autowired
  DateFormatter dateFormatter;

  public WeatherDto toWeatherDto(WeatherForecastDTO weatherForecastDTO) {
    return WeatherDto.builder()
      .forecastDate(dateFormatter.parse(weatherForecastDTO.getForecastDate()))
      .maxTemp(weatherForecastDTO.getForecastMaxTemp().getValue())
      .minTemp(weatherForecastDTO.getForecastMinTemp().getValue())
      .maxRh(weatherForecastDTO.getForecastMaxRh().getValue())
      .minRh(weatherForecastDTO.getForecastMinRh().getValue())
      .description(weatherForecastDTO.getForecastWeather())
      .build();
  }



}
