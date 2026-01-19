package com.bootcamp.demo.demo_restful_api.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Customer {
  private String name;
  private LocalDate dob;
  private String email;
}
