package com.bootcamp.demo.demo_weather.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.WeatherForecastDTO;
import com.bootcamp.demo.demo_weather.service.NineDayWeatherService;
import com.bootcamp.demo.demo_weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
  @Autowired
  private NineDayWeatherService nineDayWeatherService;
  
  @Override
  public List<WeatherForecastDTO> getWeather(DataType dataType, Lang lang) {
    return switch (dataType) {
      case NINE_DAY -> this.nineDayWeatherService.getWeathers(lang); // return NineDayDTO
    };
  }
}
