package com.bootcamp.demo.bc_mtr_station.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Bean executes after spring boot started the application

@Component
public class AppRunner implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    System.out.println("\n -= AppRunner: Server Started =- \n");
  }
  
}
