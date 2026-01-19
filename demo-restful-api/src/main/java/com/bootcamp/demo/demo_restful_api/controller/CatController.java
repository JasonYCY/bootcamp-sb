package com.bootcamp.demo.demo_restful_api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class CatController {
  // http://localhost:8080/cat?name=Sally&age=3
  @GetMapping("/cat")
  public Cat getCatRequestParam(@RequestParam String name, @RequestParam Integer age) {
    return new Cat(name, age);
  }

  // http://localhost:8080/cat/John/2
  @GetMapping("/cat/{name}/{age}")
  public Cat getCatPathVariable(@PathVariable String name, @PathVariable Integer age) {
    return new Cat(name, age);
  }

  // http://localhost:8080/catArray
  @GetMapping("/catArray")
  public Cat[] getCatArray() {
    return new Cat[]{
      new Cat("Peter", 1),
      new Cat("Tom", 2),
      new Cat("John", 3),
      new Cat("Steve", 4)
    };
  }

  // http://localhost:8080/catList
  @GetMapping("/catList")
  public List<Cat> getCatList() {
    return new ArrayList<>(List.of(
      new Cat("Peter", 1),
      new Cat("Tom", 2),
      new Cat("John", 3),
      new Cat("Steve", 4)
    ));
  }

  // http://localhost:8080/catMap
  @GetMapping("/catMap")
  public Map<String, Cat> getCatMap() {
    return new HashMap<>(Map.of(
      "Peter", new Cat("Peter", 1),
      "Tom", new Cat("Tom", 2),
      "John", new Cat("John", 3),
      "Steve", new Cat("Steve", 4)
    ));
  }

  // http://localhost:8080/catSet
  @GetMapping("/catSet")
  public Set<Cat> getCatSet() {
    return new HashSet<>(Set.of(
      new Cat("Peter", 1),
      new Cat("Tom", 2),
      new Cat("John", 3),
      new Cat("Steve", 4)
    ));
  }
  
  


  @Getter
  @AllArgsConstructor
  @EqualsAndHashCode
  public class Cat {
    private String name;
    private int age;
  }
  
  
}
