package com.bootcamp.demo.demo_database.service;

import java.util.List;
import com.bootcamp.demo.demo_database.entity.CustomerEntity;

public interface CustomerService {
  CustomerEntity create(CustomerEntity customerEntity);

  List<CustomerEntity> getCustomers();

  CustomerEntity getById(Long id);

  void deleteById(Long id);

  CustomerEntity updateById(Long id, CustomerEntity customerEntity);
}
