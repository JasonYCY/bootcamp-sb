package com.bootcamp.demo.demo_weather.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=fnd&lang=en

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NineDayForecastDTO {

  @JsonProperty("generalSituation")
  private String generalSituation;

  @JsonProperty("weatherForecast")
  private List<WeatherForecastDTO> weatherForecast;

  @JsonProperty("updateTime")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "Asia/Hong_Kong")
  private LocalDateTime updateTime;



}
