package com.bootcamp.demo.demo_external_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Server Start Process (mvn spring-boot:run)
// Step 1) Component Scan (Scan all Classes under this package)
// Step 2) @Controller, @Service, @Repository, @Component, @Configuration -> Bean -> Spring Context
// Step 3) @Autowired -> Inject the Bean from Spring Context
@SpringBootApplication
public class DemoExternalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoExternalApiApplication.class, args);
	}

}
