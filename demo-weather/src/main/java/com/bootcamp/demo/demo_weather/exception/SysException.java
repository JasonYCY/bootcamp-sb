package com.bootcamp.demo.demo_weather.exception;

import lombok.Getter;

@Getter
public enum SysException {
  PARAM_NOT_MATCH(90000, "Parameters Not Match."),
  REST_CLIENT_EX(90001, "Rest Client API Call Failed.");

  private int code;
  private String message;

  private SysException(int code, String message) {
    this.code = code;
    this.message = message;
  }

}
