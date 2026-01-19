package com.bootcamp.demo.demo_restful_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CalculatorController {
  @GetMapping(value = "/sum/{x}/{y}")
  public Integer sum(@PathVariable Integer x, @PathVariable Integer y) {
    return x + y;
  }
}
