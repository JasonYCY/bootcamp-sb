package com.bootcamp.demo.demo_restful_api.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class CalculatorController {
  // http://localhost:8080/sum/3/8
  @GetMapping(value = "/sum/{x}/{y}")
  public Integer sum(@PathVariable Integer x, @PathVariable Integer y) {
    return x + y;
  }

  
  // http://localhost:8080/minus/3/8
  @GetMapping(value = "/minus/{x}/{y}")
  public Integer minus(@PathVariable Integer x, @PathVariable Integer y) {
    return x - y;
  }

  // http://localhost:8080/multiply/3/8
  @GetMapping(value = "/multiply/{x}/{y}")
  public Double multiply(@PathVariable Double x, @PathVariable Double y) {
      return x * y;
  }

  // http://localhost:8080/divide?x=10&y=3
  @GetMapping(value = "/divide")
  public Double divide(@RequestParam Double x, @RequestParam Double y) {
    return BigDecimal.valueOf(x)
      .divide(BigDecimal.valueOf(y), 2, RoundingMode.HALF_UP)
      .doubleValue();
  }
  
}
