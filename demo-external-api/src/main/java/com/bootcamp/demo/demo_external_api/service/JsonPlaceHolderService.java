package com.bootcamp.demo.demo_external_api.service;

import java.util.List;
import com.bootcamp.demo.demo_external_api.model.Cat;
import com.bootcamp.demo.demo_external_api.model.dto.CommentDTO;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;

public interface JsonPlaceHolderService {
  List<UserDTO> getUsers();

  List<PostDTO> getPosts();

  List<CommentDTO> getComments();

  Cat getSuperCat();



}
