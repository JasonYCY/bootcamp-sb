package com.bootcamp.demo.bc_mtr_station.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LineSignalDto {
  private String line;
  private String signal;
  private List<String> delayStation;
  private String curr_time;
  private String sys_time;
  
}
