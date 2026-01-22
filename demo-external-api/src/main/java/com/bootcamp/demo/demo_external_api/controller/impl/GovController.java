package com.bootcamp.demo.demo_external_api.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_external_api.controller.GovOperation;
import com.bootcamp.demo.demo_external_api.dto.CommentDto;
import com.bootcamp.demo.demo_external_api.dto.PostDto;
import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.mapper.DtoMapper;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@RestController // Create Bean
public class GovController implements GovOperation {
  @Autowired
  private JsonPlaceHolderService jsonPlaceHolderService;
  @Autowired
  private DtoMapper dtoMapper;
  
  @Override
  public List<UserDto> getJPHUsers() {
    return jsonPlaceHolderService.getUsers().stream()
      .map(e -> dtoMapper.map(e))
      .collect(Collectors.toList());
  }

  @Override
  public List<PostDto> getJPHPostDTOs() {
    return jsonPlaceHolderService.getPosts().stream()
      .map(e -> dtoMapper.map(e))
      .collect(Collectors.toList());
  }

  @Override
  public List<CommentDto> getJPHComments() {
    return jsonPlaceHolderService.getComments().stream()
      .map(e -> dtoMapper.map(e))
      .collect(Collectors.toList());
  }



}
