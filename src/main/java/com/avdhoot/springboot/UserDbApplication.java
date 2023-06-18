package com.avdhoot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UserDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDbApplication.class, args);
	}

}
