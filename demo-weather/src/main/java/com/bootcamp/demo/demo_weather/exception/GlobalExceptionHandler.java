package com.bootcamp.demo.demo_weather.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = IllegalArgumentException.class)
  public ExceptionDTO handle(IllegalArgumentException e) {
    return ExceptionDTO.builder()
      .code(SysException.PARAM_NOT_MATCH.getCode())
      .message(SysException.PARAM_NOT_MATCH.getMessage() + " " + e.getMessage())
      .build();
  }

  @ExceptionHandler(value = RestClientException.class)
  public ExceptionDTO handle(RestClientException e) {
    return ExceptionDTO.builder()
      .code(SysException.GET_REQUEST_FAIL.getCode())
      .message(SysException.GET_REQUEST_FAIL.getMessage() + " " + e.getMessage())
      .build();
  }



}
