package com.bootcamp.demo.demo_external_api.mapper;

import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;

public class DtoMapper {
  public static UserDto map(UserDTO userDTO) {
    return new UserDto(userDTO.getId(), userDTO.getName(), userDTO.getUsername(), userDTO.getEmail());
  }
}
