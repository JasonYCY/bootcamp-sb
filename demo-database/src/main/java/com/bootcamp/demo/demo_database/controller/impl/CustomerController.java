package com.bootcamp.demo.demo_database.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_database.controller.CustomerOperation;
import com.bootcamp.demo.demo_database.entity.CustomerEntity;
import com.bootcamp.demo.demo_database.service.CustomerService;

@RestController // @Controller + @ResponseBody
public class CustomerController implements CustomerOperation {
  @Autowired
  private CustomerService customerService;

  @Override
  public CustomerEntity create(CustomerEntity customerEntity) {
    List<CustomerEntity> customers = customerService.getCustomers();
    if (customers.contains(customerEntity)) {
      return null;
    }
    return customerService.create(customerEntity);
  }

  @Override
  public List<CustomerEntity> getCustomers() {
    return customerService.getCustomers();
  }

  @Override
  public CustomerEntity getById(Long id) {
    return customerService.getById(id);
  }

  @Override
  public void deleteById(Long id) {
    customerService.deleteById(id);
  }

  @Override
  public CustomerEntity updateById(Long id, CustomerEntity customerEntity) {
    return customerService.updateById(id, customerEntity);
  }
  
}
