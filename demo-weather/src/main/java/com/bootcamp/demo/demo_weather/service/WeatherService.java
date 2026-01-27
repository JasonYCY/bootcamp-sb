package com.bootcamp.demo.demo_weather.service;

import java.time.LocalDate;
import java.util.List;
import com.bootcamp.demo.demo_weather.entity.WeatherEntity;
import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.WeatherForecastDTO;

public interface WeatherService {
  List<WeatherForecastDTO> getWeather(DataType dataType, Lang lang);

  List<WeatherEntity> getDatabaseWeathersByForecastDate(LocalDate forecastDate);

  List<WeatherEntity> getWeatherBetween(LocalDate start, LocalDate end);


}
