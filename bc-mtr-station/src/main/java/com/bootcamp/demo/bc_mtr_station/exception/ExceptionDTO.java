package com.bootcamp.demo.bc_mtr_station.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExceptionDTO {
  private int code;
  private String message;



}
