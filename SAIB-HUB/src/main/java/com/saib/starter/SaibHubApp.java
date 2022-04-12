package com.saib.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com")
@EntityScan(basePackages = {"com.saib.model"})  // scan JPA entities
@EnableJpaRepositories(basePackages ={"com.saib.repository"})
public class SaibHubApp {
	
	public static void main(String[] args) {
		SpringApplication.run(SaibHubApp.class, args);
	}

}
