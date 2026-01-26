package com.bootcamp.demo.demo_weather.service;

import java.util.List;
import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.WeatherForecastDTO;

public interface WeatherService {
  List<WeatherForecastDTO> getWeather(DataType dataType, Lang lang);
}
