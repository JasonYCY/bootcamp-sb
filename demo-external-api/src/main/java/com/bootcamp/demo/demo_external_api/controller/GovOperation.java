package com.bootcamp.demo.demo_external_api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_external_api.dto.UserDto;

// https://jsonplaceholder.typicode.com/users

public interface GovOperation {
  @GetMapping("/gov/jph/users")
  List<UserDto> getJPHUsers();



}
