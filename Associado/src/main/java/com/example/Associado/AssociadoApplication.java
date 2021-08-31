package com.example.Associado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AssociadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssociadoApplication.class, args);
	}

}
