package com.bootcamp.demo.demo_weather.exception;

import lombok.Getter;

@Getter
public enum SysException {
  PARAM_NOT_MATCH(90000, "Parameters not match.");

  private int code;
  private String message;

  private SysException(int code, String message) {
    this.code = code;
    this.message = message;
  }

}
