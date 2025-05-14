package com.ebac.jorgechediack.categoria_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CategoriaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoriaServiceApplication.class, args);
	}

}
