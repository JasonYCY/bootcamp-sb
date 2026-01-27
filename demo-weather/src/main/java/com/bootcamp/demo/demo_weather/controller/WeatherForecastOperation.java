package com.bootcamp.demo.demo_weather.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_weather.dto.WeatherDto;
import com.bootcamp.demo.demo_weather.entity.WeatherEntity;

public interface WeatherForecastOperation {
  @GetMapping("/weathers")
  List<WeatherDto> getNineDayWeathers(@RequestParam String dataType, @RequestParam String lang);

  @GetMapping("/weather/agent")
  List<WeatherEntity> getDatabaseWeathersByForecastDate(@RequestParam LocalDate forecastDate);

  @GetMapping("/weather/between")
  List<WeatherEntity> getDatabaseWeathersByForecastDate(@RequestParam LocalDate start, @RequestParam LocalDate end);



}
