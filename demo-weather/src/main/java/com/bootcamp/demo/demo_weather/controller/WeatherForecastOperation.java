package com.bootcamp.demo.demo_weather.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_weather.dto.WeatherDto;

public interface WeatherForecastOperation {
  @GetMapping("/weathers")
  List<WeatherDto> getNineDayWeathers(@RequestParam String dataType, @RequestParam String lang);



}
