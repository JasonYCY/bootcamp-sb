package com.bootcamp.demo.demo_weather.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_weather.entity.WeatherEntity;
import com.bootcamp.demo.demo_weather.mapper.EntityMapper;
import com.bootcamp.demo.demo_weather.model.dto.NineDayForecastDTO;
import com.bootcamp.demo.demo_weather.model.dto.WeatherForecastDTO;
import com.bootcamp.demo.demo_weather.repository.WeatherForecastRepository;
import com.bootcamp.demo.demo_weather.service.WeatherForecastService;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {
  private static String url = "https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=fnd&lang=en";
  
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private EntityMapper entityMapper;

  @Autowired
  private WeatherForecastRepository weatherForecastRepository;

  @Override
  public List<WeatherForecastDTO> getNineDayWeathers() {
    NineDayForecastDTO nineDayForecastDTO = restTemplate.getForObject(url, NineDayForecastDTO.class);

    String updateTime = nineDayForecastDTO.getUpdateTime();
    List<WeatherForecastDTO> weathers = nineDayForecastDTO.getWeatherForecast();

    // If (WeatherForecastRepository has no record with updateTime == updateTime in current External API call) {
    //    Map List<WeatherForecastDTO> -> List<WeatherEntity>
    //    save to database (with spring boot JPA repository)
    // }
    if (weatherForecastRepository.findByDataUpdateTime(updateTime).size() == 0) {
      List<WeatherEntity> weatherEntities = weathers.stream()
        .map(e -> entityMapper.toWeatherEntity(e, updateTime))
        .toList();
      weatherForecastRepository.saveAll(weatherEntities);
    }
    
    return weathers;
  }



}
