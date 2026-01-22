package com.bootcamp.demo.demo_external_api.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
  private Long userId;
  private Long id;
  private String title;
  private String body;
}
