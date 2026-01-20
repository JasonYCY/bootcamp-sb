package com.bootcamp.demo.demo_database.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_database.entity.CustomerEntity;

public interface CustomerOperation {
  @PostMapping("/customer")
  CustomerEntity create(@RequestBody CustomerEntity customerEntity);

  @GetMapping("/customers")
  List<CustomerEntity> getCustomers();

  @GetMapping("/customer")
  CustomerEntity getById(@RequestParam Long id);

  @DeleteMapping("/customer")
  void deleteById(@RequestParam Long id);

  @PutMapping("/customer")
  CustomerEntity updateById(@RequestParam Long id, @RequestBody CustomerEntity customerEntity);
  
}
