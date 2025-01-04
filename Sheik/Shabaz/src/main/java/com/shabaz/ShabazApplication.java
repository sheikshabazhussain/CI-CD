package com.shabaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class ShabazApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShabazApplication.class, args);
	}

}
