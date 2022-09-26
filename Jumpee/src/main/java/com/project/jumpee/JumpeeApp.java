package com.project.jumpee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)
public class JumpeeApp {

	public static void main(String[] args) {
		SpringApplication.run(JumpeeApp.class, args);
	}

}