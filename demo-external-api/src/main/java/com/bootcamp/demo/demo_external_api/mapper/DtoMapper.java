package com.bootcamp.demo.demo_external_api.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_external_api.dto.CommentDto;
import com.bootcamp.demo.demo_external_api.dto.PostDto;
import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.model.dto.CommentDTO;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;

@Component
public class DtoMapper {
  // from static method to instance method
  public UserDto map(UserDTO userDTO) {
    return new UserDto(
      userDTO.getId(),
      userDTO.getName(),
      userDTO.getUsername(),
      userDTO.getEmail()
    );
  }

  public PostDto map(PostDTO postDTO) {
    return new PostDto(
      postDTO.getId(),
      postDTO.getTitle(),
      postDTO.getBody()
    );
  }

  public CommentDto map(CommentDTO commentDTO) {
    return new CommentDto(
      commentDTO.getId(),
      commentDTO.getName(),
      commentDTO.getEmail(),
      commentDTO.getBody()
    );
  }
}
