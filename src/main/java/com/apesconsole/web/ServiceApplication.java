package com.apesconsole.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:mqtt-integration.xml")
public class ServiceApplication {
	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "apesconsole-hub");
		SpringApplication.run(ServiceApplication.class, args);
	}
}
