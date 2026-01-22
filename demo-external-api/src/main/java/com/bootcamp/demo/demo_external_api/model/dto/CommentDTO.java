package com.bootcamp.demo.demo_external_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;
}
