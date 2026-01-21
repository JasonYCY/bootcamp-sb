package com.bootcamp.demo.demo_external_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Data Transfer Object
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  // attribute
  private Long id;
  private String name;
  private String username;
  private String email;
  private AddressDTO address;
  private String phone;
  private String website;
  private CompanyDTO company;



  // inner class
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class AddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GeoDTO {
      private String lat;
      private String lng;
    }
  }
  
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class CompanyDTO {
    private String name;
    private String catchPhrase;
    private String bs;
  }



}
