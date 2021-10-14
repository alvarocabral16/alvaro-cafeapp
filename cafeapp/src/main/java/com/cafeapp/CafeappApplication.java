package com.cafeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CafeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeappApplication.class, args);
	}

}
