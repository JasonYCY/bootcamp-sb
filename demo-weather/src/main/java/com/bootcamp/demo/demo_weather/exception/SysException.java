package com.bootcamp.demo.demo_weather.exception;

import lombok.Getter;

@Getter
public enum SysException {
  PARAM_NOT_MATCH(90000, "Parameters not match."),
  GET_REQUEST_FAIL(90001, "Failed to retrieve data from Hong Kong Observatory API");

  private int code;
  private String message;

  private SysException(int code, String message) {
    this.code = code;
    this.message = message;
  }

}
