package com.bootcamp.demo.demo_external_api.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_external_api.controller.GovOperation;
import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@RestController
public class GovController implements GovOperation {
  @Autowired
  private JsonPlaceHolderService jsonPlaceHolderService;
  
  @Override
  public List<UserDto> getJPHUsers() {
    return jsonPlaceHolderService.getUsers().stream()
      .map(e -> new UserDto(e.getId(), e.getName(), e.getUsername(), e.getEmail()))
      .collect(Collectors.toList());
  }



}
