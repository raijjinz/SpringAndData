package com.example.PostgreSpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostgreSpringDemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello database server");
		SpringApplication.run(PostgreSpringDemoApplication.class, args);
	}

}
