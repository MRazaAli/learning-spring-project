package com.example.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication

// makes this class serve rest endpoints
@RestController
public class SpringProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringProjectApplication.class, args);
	}

}
