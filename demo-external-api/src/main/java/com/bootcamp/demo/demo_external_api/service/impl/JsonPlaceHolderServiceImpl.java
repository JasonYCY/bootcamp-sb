package com.bootcamp.demo.demo_external_api.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_external_api.entity.CommentEntity;
import com.bootcamp.demo.demo_external_api.entity.PostEntity;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;
import com.bootcamp.demo.demo_external_api.mapper.EntityMapper;
import com.bootcamp.demo.demo_external_api.model.Cat;
import com.bootcamp.demo.demo_external_api.model.dto.CommentDTO;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;
import com.bootcamp.demo.demo_external_api.repository.CommentRepository;
import com.bootcamp.demo.demo_external_api.repository.PostRepository;
import com.bootcamp.demo.demo_external_api.repository.UserRepository;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@Service // Create Bean
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private EntityMapper entityMapper;

  @Autowired
  @Qualifier(value = "superCat") // Bean Name
  private Cat abc;



  @Override
  public Cat getSuperCat() {
    return abc;
  }

  @Override
  public List<UserDTO> getUsers() {
    
    String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] userDTOs = restTemplate.getForObject(url, UserDTO[].class);

    if (userRepository.count() == 0) {
      List<UserEntity> userEntities = Arrays.asList(userDTOs).stream()
        .map(e -> entityMapper.map(e))
        .collect(Collectors.toList());
      userRepository.saveAll(userEntities);
    }

    return Arrays.asList(userDTOs);
  }

  @Override
  public List<PostDTO> getPosts() {
    String url = "https://jsonplaceholder.typicode.com/posts";
    PostDTO[] postDTOs = restTemplate.getForObject(url, PostDTO[].class);

    if (postRepository.count() == 0) {
      List<PostEntity> postEntities = Arrays.asList(postDTOs).stream()
        .map(e -> entityMapper.map(e))
        .collect(Collectors.toList());
      postRepository.saveAll(postEntities);
    }

    return Arrays.asList(postDTOs);
  }

  @Override
  public List<CommentDTO> getComments() {
    String url = "https://jsonplaceholder.typicode.com/comments";
    CommentDTO[] commentDTOs = restTemplate.getForObject(url, CommentDTO[].class);

    if (commentRepository.count() == 0) {
      List<CommentEntity> commentEntities = Arrays.asList(commentDTOs).stream()
        .map(e -> entityMapper.map(e))
        .collect(Collectors.toList());
      commentRepository.saveAll(commentEntities);
    }

    return Arrays.asList(commentDTOs);
  }



}
