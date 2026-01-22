package com.bootcamp.demo.demo_external_api.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_external_api.model.Cat;
import com.bootcamp.demo.demo_external_api.model.dto.CommentDTO;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@Service // Create Bean
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  @Qualifier(value = "superCat") // Bean Name
  private Cat abc;

  @Override
  public List<UserDTO> getUsers() {
    String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] userDTOs = restTemplate.getForObject(url, UserDTO[].class);

    // insert into database
    // entity -> store all the field in UserDTO into database

    return Arrays.asList(userDTOs);
  }

  @Override
  public Cat getSuperCat() {
    return abc;
  }

  @Override
  public List<PostDTO> getPosts() {
    String url = "https://jsonplaceholder.typicode.com/posts";
    PostDTO[] postDTOs = restTemplate.getForObject(url, PostDTO[].class);
    return Arrays.asList(postDTOs);
  }

  @Override
  public List<CommentDTO> getComments() {
    String url = "https://jsonplaceholder.typicode.com/comments";
    CommentDTO[] commentDTOs = restTemplate.getForObject(url, CommentDTO[].class);
    return Arrays.asList(commentDTOs);
  }



}
