package com.bootcamp.demo.demo_restful_api.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_restful_api.model.Customer;
import com.bootcamp.demo.demo_restful_api.model.Database;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@Controller
@ResponseBody
public class CustomerController {
  // static variable
  private static long nextCustomerId = 1;

  // Get
  @GetMapping("/customer")
  public Customer getCustomerByIndex(@RequestParam Integer index) {
    return Database.customers.get(index);
  }

  @GetMapping("/customer/{id}")
  public Customer getCustomerById(@PathVariable Long id) {
    return Database.customers.stream()
      .filter(customer -> customer.getId().equals(id))
      .findAny()
      .orElse(null);
  }

  @GetMapping("/customers")
  public List<Customer> getCustomers() {
    return Database.customers;
  }

  // Post
  @PostMapping("/customer")
  public boolean createCustomer(@RequestBody Customer customer) {
    customer.setId(nextCustomerId++);
    return Database.customers.add(customer);
  }

  // Delete
  @DeleteMapping("/customer")
  public boolean deleteByName(@RequestParam String name) {
    return Database.customers.removeIf(customer -> customer.getName().equals(name));
  }

  // Put
  @PutMapping("/customer")
  public boolean updateById(@RequestParam Long id, @RequestBody Customer newCustomer) {
    if (!id.equals(newCustomer.getId())) return false;

    Optional<Customer> target = Database.customers.stream()
      .filter(customer -> customer.getId().equals(id))
      .findAny();

    if (target.isPresent() && Database.customers.removeIf(customer -> customer.getId().equals(id))) {
      Database.customers.add(newCustomer);
      return true; 
    }
    return false;
  }

  // Patch
  @PatchMapping("/customer/email/{email}")
  public Customer patchEmailById(@PathVariable String email, @RequestParam Long id) {
    Optional<Customer> target = Database.customers.stream()
      .filter(customer -> customer.getId().equals(id))
      .findAny();
    
    if (target.isPresent()) {
      Customer customer = target.get();
      customer.setEmail(email);
      return customer;
    }
    return null;
  }
  
  
}
