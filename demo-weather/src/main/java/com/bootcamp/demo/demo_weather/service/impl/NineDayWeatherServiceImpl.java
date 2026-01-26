package com.bootcamp.demo.demo_weather.service.impl;

import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_weather.entity.WeatherEntity;
import com.bootcamp.demo.demo_weather.mapper.EntityMapper;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.NineDayForecastDTO;
import com.bootcamp.demo.demo_weather.model.dto.WeatherForecastDTO;
import com.bootcamp.demo.demo_weather.repository.WeatherForecastRepository;
import com.bootcamp.demo.demo_weather.service.NineDayWeatherService;

@Service
public class NineDayWeatherServiceImpl implements NineDayWeatherService {
  // private static String url = "https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=fnd&lang=en";
  
  @Value(value = "${external-api.hk-observatory.domain}")
  private String domain;

  @Value(value = "${external-api.hk-observatory.weather.path-segment}")
  private String pathSegment;

  @Value(value = "${external-api.hk-observatory.weather.path}")
  private String path;

  @Value(value = "${external-api.hk-observatory.weather.dataset.nine-day}")
  private String dataType;



  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private EntityMapper entityMapper;

  @Autowired
  private WeatherForecastRepository weatherForecastRepository;

  @Override
  public List<WeatherForecastDTO> getWeathers(Lang lang) {
    MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
    paramMap.put("dataType", List.of(dataType));
    paramMap.put("lang", List.of(lang.getValue()));

    String url = UriComponentsBuilder.newInstance()
      .scheme("https")
      .host(domain)
      .pathSegment(pathSegment)
      .path(path)
      .queryParams(paramMap)
      .build()
      .toString();

    NineDayForecastDTO nineDayForecastDTO = restTemplate.getForObject(url, NineDayForecastDTO.class);
    OffsetDateTime updateTime = nineDayForecastDTO.getUpdateTime();
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
