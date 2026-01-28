package com.bootcamp.demo.bc_mtr_station.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineWithStationsDto {
  private String lineCode;
  private String lineDescription;
  private List<StationDetailDto> stations = new ArrayList<>();

  public void addStation(StationDetailDto station) {
    this.stations.add(station);
  }
}


