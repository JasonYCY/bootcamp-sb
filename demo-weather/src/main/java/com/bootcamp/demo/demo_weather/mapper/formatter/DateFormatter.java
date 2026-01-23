package com.bootcamp.demo.demo_weather.mapper.formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class DateFormatter {
  public String parse(String originalDate) {
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    return LocalDate.parse(originalDate, inputFormatter).format(outputFormatter);
  }
}
