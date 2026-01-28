package com.bootcamp.demo.bc_mtr_station.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class DateMapper {
  private final DateTimeFormatter FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public String mapToString(LocalDateTime dateTime) {
    if (dateTime == null)
      return null;
    return dateTime.format(FORMATTER);
  }
}
