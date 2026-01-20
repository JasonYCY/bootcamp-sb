package com.bootcamp.demo.demo_database.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_database.entity.CustomerEntity;
import com.bootcamp.demo.demo_database.repository.CustomerRepository;
import com.bootcamp.demo.demo_database.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
  @Autowired
  private CustomerRepository customerRepository;
  // save / saveAll -> INSERT / UPDATE
  // findById / findAll -> SELECT
  // deleteById -> DELETE

  @Override
  public CustomerEntity create(CustomerEntity customerEntity) {
    return customerRepository.save(customerEntity);
  }

  @Override
  public List<CustomerEntity> getCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public CustomerEntity getById(Long id) {
    return customerRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Long id) {
    customerRepository.deleteById(id);
  }

  @Override
  public CustomerEntity updateById(Long id, CustomerEntity customerEntity) {
    // return customerRepository.findById(id)
    //   .map(entity -> {
    //     entity.setDob(customerEntity.getDob());
    //     entity.setEmail(customerEntity.getEmail());
    //     entity.setName(customerEntity.getName());
    //     return customerRepository.save(entity);
    //   }).orElse(null);

    Optional<CustomerEntity> optionalEntity = customerRepository.findById(id);
    if (optionalEntity.isPresent()) {
      CustomerEntity entity = optionalEntity.get();
      entity.setDob(customerEntity.getDob());
      entity.setEmail(customerEntity.getEmail());
      entity.setName(customerEntity.getName());
      return customerRepository.save(entity);
    }
    return null;
  }
  
}
