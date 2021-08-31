package com.example.pauta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class PautaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PautaApplication.class, args);
	}

}
