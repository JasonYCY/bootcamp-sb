package com.bootcamp.demo.demo_weather.service;

import java.util.List;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.WeatherForecastDTO;

public interface NineDayWeatherService {
  List<WeatherForecastDTO> getWeathers(Lang lang);
  
}
