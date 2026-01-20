package com.bootcamp.demo.demo_restful_api.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_restful_api.model.Customer;
import com.bootcamp.demo.demo_restful_api.model.Database;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class CustomerController {
  // Get
  @GetMapping("/customer")
  public Customer getCustomerByIndex(@RequestParam Integer index) {
    return Database.customers.get(index);
  }

  @GetMapping("/customers")
  public List<Customer> getCustomers() {
    return Database.customers;
  }

  // Post
  @PostMapping("/customer")
  public boolean createCustomer(@RequestBody Customer customer) {
    return Database.customers.add(customer);
  }

  // Delete
  @DeleteMapping("/customer")
  public boolean deleteByName(@RequestParam String name) {
    return Database.customers.removeIf(customer -> customer.getName().equals(name));
  }
  
  
}
