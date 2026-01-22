package com.bootcamp.demo.demo_external_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostDto {
  private Long id;
  private String title;
  private String body;
}
