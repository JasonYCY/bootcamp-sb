package com.bootcamp.demo.bc_mtr_station;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BcMtrStationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcMtrStationApplication.class, args);
	}

}
