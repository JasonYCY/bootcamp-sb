package com.bootcamp.demo.demo_sb_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HellowWorldController {
  @GetMapping(value = "/hello")
  public String helloworld() {
    return "Hello! Welcome to Spring Boot";
  }

  @GetMapping(value = "/bootcamp")
  public String bootcamp() {
    return "I love Java";
  }




}
