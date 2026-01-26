package com.bootcamp.demo.demo_weather.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_weather.controller.WeatherForecastOperation;
import com.bootcamp.demo.demo_weather.dto.WeatherDto;
import com.bootcamp.demo.demo_weather.mapper.DtoMapper;
import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.service.WeatherService;

@RestController
public class WeatherForecastController implements WeatherForecastOperation {
  @Autowired
  private WeatherService weatherService;

  @Autowired
  private DtoMapper dtoMapper;

  @Override
  public List<WeatherDto> getNineDayWeathers(String dataType, String lang) {
    return weatherService.getWeather(DataType.of(dataType), Lang.of(lang))
      .stream()
      .map(e -> dtoMapper.toWeatherDto(e))
      .toList();
  }



}
