package com.jmb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IdpbackendninjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdpbackendninjaApplication.class, args);
	}

}

