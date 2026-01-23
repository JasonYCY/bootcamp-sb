package com.bootcamp.demo.demo_external_api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_external_api.entity.CommentEntity;
import com.bootcamp.demo.demo_external_api.entity.PostEntity;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;
import com.bootcamp.demo.demo_external_api.model.dto.CommentDTO;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;
import com.bootcamp.demo.demo_external_api.repository.PostRepository;
import com.bootcamp.demo.demo_external_api.repository.UserRepository;

@Component
public class EntityMapper {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  public UserEntity map(UserDTO userDTO) {
    return UserEntity.builder()
      .name(userDTO.getName())
      .username(userDTO.getUsername())
      .email(userDTO.getEmail())
      .street(userDTO.getAddress().getStreet())
      .suite(userDTO.getAddress().getSuite())
      .city(userDTO.getAddress().getCity())
      .zipcode(userDTO.getAddress().getZipcode())
      .lat(userDTO.getAddress().getGeo().getLat())
      .lng(userDTO.getAddress().getGeo().getLng())
      .phone(userDTO.getPhone())
      .website(userDTO.getWebsite())
      .company_name(userDTO.getCompany().getName())
      .company_catchPhrase(userDTO.getCompany().getCatchPhrase())
      .company_bs(userDTO.getCompany().getBs())
      .build();
  }

  public PostEntity map(PostDTO postDTO) {
    UserEntity userEntity = userRepository.findById(postDTO.getUserId())
      .orElseThrow(() -> new IllegalArgumentException("User ID Not Found"));

    return PostEntity.builder()
      .title(postDTO.getTitle())
      .body(postDTO.getBody())
      .userEntity(userEntity)
      .build();
  }

  public CommentEntity map(CommentDTO commentDTO) {
    PostEntity postEntity = postRepository.findById(commentDTO.getPostId())
      .orElseThrow(() -> new IllegalArgumentException("Post ID Not Found"));

    return CommentEntity.builder()
      .name(commentDTO.getName())
      .email(commentDTO.getEmail())
      .body(commentDTO.getBody())
      .postEntity(postEntity)
      .build();
  }
}
