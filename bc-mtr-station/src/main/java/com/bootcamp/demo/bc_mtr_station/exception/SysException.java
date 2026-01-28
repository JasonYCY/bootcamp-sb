package com.bootcamp.demo.bc_mtr_station.exception;

import lombok.Getter;

@Getter
public enum SysException {
  PARAM_NOT_MATCH(90000, "Parameters Not Match."),
  REST_CLIENT_EX(90001, "Rest Client API Call Failed."),
  TYPE_DEFINITION_ERROR(90002, "HTTP Message Conversion Failed."),
  UNSUPPORTED_OPERATION(99999, "Unsupported Operation.");

  private int code;
  private String message;

  private SysException(int code, String message) {
    this.code = code;
    this.message = message;
  }

}
