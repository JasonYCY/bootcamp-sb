package com.bootcamp.demo.bc_mtr_station.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StationDto {
  private Long id;
  private String station_code;
  private String description;
  
}
