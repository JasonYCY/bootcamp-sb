package com.bootcamp.demo.demo_external_api.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;
import com.bootcamp.demo.demo_external_api.service.JsonPlaceHolderService;

@Service
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService {
  @Override
  public List<UserDTO> getUsers() {
    String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] userDTOs = new RestTemplate().getForObject(url, UserDTO[].class);
    return Arrays.asList(userDTOs);
  }



}
