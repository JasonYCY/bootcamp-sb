package com.bootcamp.demo.demo_external_api.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@Service // Create Bean
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService {
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<UserDTO> getUsers() {
    String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] userDTOs = restTemplate.getForObject(url, UserDTO[].class);

    // insert into database
    // entity -> store all the field in UserDTO into database

    return Arrays.asList(userDTOs);
  }



}
