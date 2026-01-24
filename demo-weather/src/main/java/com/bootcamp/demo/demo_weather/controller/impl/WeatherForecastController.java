package com.bootcamp.demo.demo_weather.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_weather.controller.WeatherForecastOperation;
import com.bootcamp.demo.demo_weather.dto.WeatherDto;
import com.bootcamp.demo.demo_weather.mapper.DtoMapper;
import com.bootcamp.demo.demo_weather.service.WeatherForecastService;

@RestController
public class WeatherForecastController implements WeatherForecastOperation {
  @Autowired
  private WeatherForecastService weatherForecastService;

  @Autowired
  private DtoMapper dtoMapper;

  @Override
  public List<WeatherDto> getNineDayWeathers() {
    return weatherForecastService.getNineDayWeathers()
      .stream()
      .map(e -> dtoMapper.toWeatherDto(e))
      .toList();
  }



}
