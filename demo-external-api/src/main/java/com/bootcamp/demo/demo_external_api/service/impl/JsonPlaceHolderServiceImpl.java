package com.bootcamp.demo.demo_external_api.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
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
  // Check Dependency -> applicationl.yml
  @Value("${external-api.jsonplaceholder.domain}")
  private String domain;

  @Value("${external-api.jsonplaceholder.uri.users}")
  private String userPath;

  @Value("${external-api.jsonplaceholder.uri.posts}")
  private String postPath;

  @Value("${external-api.jsonplaceholder.uri.comments}")
  private String commentPath;



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
    String url = UriComponentsBuilder.newInstance()
      .scheme("https")
      .host(domain)
      .path(userPath)
      .build()
      .toUriString();
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
    String url = UriComponentsBuilder.newInstance()
      .scheme("https")
      .host(domain)
      .path(postPath)
      .build()
      .toUriString();
    PostDTO[] postDTOs = restTemplate.getForObject(url, PostDTO[].class);

    if (postRepository.count() == 0) {
      List<PostEntity> postEntities = Arrays.asList(postDTOs).stream()
        // .map(e -> {
        //   UserEntity userEntity = userRepository.findById(e.getUserId())
        //     .orElseThrow(() -> new IllegalArgumentException("User ID Not Found"));
        //   PostEntity postEntity = entityMapper.map(e);
        //   postEntity.setUserEntity(userEntity);
        //   return postEntity;
        // })
        .map(e -> entityMapper.map(e))
        .collect(Collectors.toList());
      postRepository.saveAll(postEntities);
    }

    return Arrays.asList(postDTOs);
  }

  @Override
  public List<CommentDTO> getComments() {
    String url = UriComponentsBuilder.newInstance()
      .scheme("https")
      .host(domain)
      .path(commentPath)
      .build()
      .toUriString();
    CommentDTO[] commentDTOs = restTemplate.getForObject(url, CommentDTO[].class);

    if (commentRepository.count() == 0) {
      List<CommentEntity> commentEntities = Arrays.asList(commentDTOs).stream()
        // .map(e -> {
        //   PostEntity postEntity = postRepository.findById(e.getPostId())
        //     .orElseThrow(() -> new IllegalArgumentException("Post ID Not Found"));
        //   CommentEntity commentEntity = entityMapper.map(e);
        //   commentEntity.setPostEntity(postEntity);
        //   return commentEntity;
        // })
        .map(e -> entityMapper.map(e))
        .collect(Collectors.toList());
      commentRepository.saveAll(commentEntities);
    }

    return Arrays.asList(commentDTOs);
  }



}
