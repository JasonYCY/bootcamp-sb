package com.bootcamp.demo.demo_weather.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

// sorting ascending date (no need to sort, the data is sorted by default)

@Getter
@Builder
public class WeatherDto {
  // forecastDate -> 2026-01-24
  // maxTemp -> 19
  // minTemp -> 14
  // maxRh -> 80
  // minRh -> 55
  // description -> "Sunny periods. Rather cool in the morning. Dry during the day."

  private LocalDate forecastDate;
  private Integer maxTemp;
  private Integer minTemp;
  private Integer maxRh;
  private Integer minRh;
  private String description;



}

// Every time you call weatherAPI, store to database
