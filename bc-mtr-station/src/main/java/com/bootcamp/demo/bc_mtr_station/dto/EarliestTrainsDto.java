package com.bootcamp.demo.bc_mtr_station.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EarliestTrainsDto {
  private String currTime;          // 格式: "2022-04-25 15:19:59"
  private String sysTime;           // 格式: "2022-04-25 15:19:59"
  private String currentStation;    // 车站代码，如 "TKO"
  private List<TrainDto> trains;   // 列车列表
}
