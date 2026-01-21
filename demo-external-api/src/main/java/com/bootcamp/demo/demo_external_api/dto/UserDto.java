package com.bootcamp.demo.demo_external_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
  // attribute
  private Long id;
  private String name;
  private String username;
  private String email;
  
}
