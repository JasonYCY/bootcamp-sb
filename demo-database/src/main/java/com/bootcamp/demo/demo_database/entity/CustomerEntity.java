package com.bootcamp.demo.demo_database.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity // Create table in Database
@Table(name = "customers") // Exact table name in MySQL
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerEntity {
  // Entity: Use Java Code to write a create table statement
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
  private Long id;

  @Setter
  @EqualsAndHashCode.Include
  @Column(name = "c_name", length = 50) // default 255
  private String name;

  @Setter
  @EqualsAndHashCode.Include
  @Column(name = "c_dob")
  private LocalDate dob;

  @Setter
  @EqualsAndHashCode.Include
  @Column(name = "c_email", length = 50)
  private String email;

}
