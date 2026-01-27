package com.bootcamp.demo.demo_weather.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weather_forecasts")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "forecast_date")
  private LocalDate forecastDate;

  @Column(name = "week", length = 20)
  private String week;

  @Column(name = "forecast_wind", length = 100)
  private String forecastWind;

  @Column(name = "forecast_weather", length = 500)
  private String forecastWeather;

  @Column(name = "max_temp", length = 20)
  private String maxTemp; // e.g., "19 C"

  @Column(name = "min_temp", length = 20)
  private String minTemp; // e.g., "14 C"

  @Column(name = "max_humidity", length = 20)
  private String maxHumidity; // e.g., "80 percent"

  @Column(name = "min_humidity", length = 20)
  private String minHumidity; // e.g., "55 percent"

  @Column(name = "forecast_icon")
  private Integer forecastIcon;

  @Column(name = "psr", length = 10)
  private String psr;

  @Column(name = "data_update_time")
  private LocalDateTime dataUpdateTime; // From API's updateTime



}
