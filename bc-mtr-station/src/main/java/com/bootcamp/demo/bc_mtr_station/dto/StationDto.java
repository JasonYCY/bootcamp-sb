package com.bootcamp.demo.bc_mtr_station.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StationDto {
  private Long id;
  private String station_code;
  private String description;
  
}
