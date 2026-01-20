package com.bootcamp.demo.demo_restful_api.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Customer {
  @Setter
  private Long id;
  private String name;
  private LocalDate dob;
  @Setter
  private String email;
}
