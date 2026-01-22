package com.bootcamp.demo.demo_external_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentDto {
  private Long id;
  private String name;
  private String email;
  private String body;  
}
