package com.bootcamp.demo.demo_external_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;

// Hibernate / JPA (pom.xml) -> MySQL Library (pom.xml)
// Able to generate a class which implements CRUD methods (JpaRepository)
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  
}
