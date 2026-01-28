package com.bootcamp.demo.bc_mtr_station.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TrainDto {
  // {
  //   "destination": "POA",
  //   "arrivalTime": "2022-04-25 15:20:00",
  //   "direction": "UP",
  // }
  private String destination;
  private String arrivalTime;
  private String direction;
  
}
