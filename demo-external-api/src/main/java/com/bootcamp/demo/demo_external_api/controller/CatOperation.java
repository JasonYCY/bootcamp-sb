package com.bootcamp.demo.demo_external_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_external_api.model.Cat;

public interface CatOperation {
  @GetMapping("/cat/super")
  Cat getSuperCat();


}
