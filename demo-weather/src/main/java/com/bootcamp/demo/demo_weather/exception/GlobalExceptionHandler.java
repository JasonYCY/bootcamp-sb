package com.bootcamp.demo.demo_weather.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = IllegalArgumentException.class)
  public ExceptionDTO handle(IllegalArgumentException e) {
    return ExceptionDTO.builder()
      .code(SysException.PARAM_NOT_MATCH.getCode())
      .message(SysException.PARAM_NOT_MATCH.getMessage() + " " + e.getMessage())
      .build();
  }



}
