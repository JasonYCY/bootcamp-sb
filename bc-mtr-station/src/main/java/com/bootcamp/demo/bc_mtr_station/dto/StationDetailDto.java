package com.bootcamp.demo.bc_mtr_station.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StationDetailDto {
  private String stationCode;
  private String stationDescription;
  private Integer sequenceOrder;
}

