package com.bootcamp.demo.bc_mtr_station.exception;

import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

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
      .code(SysException.REST_CLIENT_EX.getCode())
      .message(SysException.REST_CLIENT_EX.getMessage() + " " + e.getMessage())
      .build();
  }

  @ExceptionHandler(value = UnsupportedOperationException.class)
  public ExceptionDTO handle(UnsupportedOperationException e) {
    return ExceptionDTO.builder()
      .code(SysException.UNSUPPORTED_OPERATION.getCode())
      .message(SysException.UNSUPPORTED_OPERATION.getMessage() + " " + e.getMessage())
      .build();
  }

  @ExceptionHandler(value = HttpMessageConversionException.class)
  public ExceptionDTO handle(HttpMessageConversionException e) {
    return ExceptionDTO.builder()
      .code(SysException.TYPE_DEFINITION_ERROR.getCode())
      .message(SysException.TYPE_DEFINITION_ERROR.getMessage() + " " + e.getMessage())
      .build();
  }

  @ExceptionHandler(value = NoResourceFoundException.class)
  public ExceptionDTO handle(NoResourceFoundException e) {
    return ExceptionDTO.builder()
      .code(SysException.RESOURCE_NOT_FOUND.getCode())
      .message(SysException.RESOURCE_NOT_FOUND.getMessage() + " " + e.getMessage())
      .build();
  }



}
