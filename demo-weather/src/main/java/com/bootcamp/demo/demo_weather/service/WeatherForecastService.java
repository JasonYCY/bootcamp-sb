package com.bootcamp.demo.demo_weather.service;

import com.bootcamp.demo.demo_weather.model.dto.NineDayForecastDTO;

public interface WeatherForecastService {
  NineDayForecastDTO getNineDayWeathers();
  
}
