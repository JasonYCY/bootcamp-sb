package com.bootcamp.demo.demo_external_api.entity;

import com.bootcamp.demo.demo_external_api.model.dto.UserDTO.AddressDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO.AddressDTO.GeoDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO.CompanyDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jph_users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // By default String -> VARCHAR(255)
  private String name;
  private String username;
  private String email;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private String lat;
  private String lng;
  private String phone;
  private String website;
  @Column(name = "company_name")
  private String company_name;
  @Column(name = "company_catch_phrase")
  private String company_catchPhrase;
  @Column(name = "company_bs")
  private String company_bs;
}
