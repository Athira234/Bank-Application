package com.sample.app;

import javax.activation.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankApplication1Application {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication1Application.class, args);
		Integer Balance = 0;
	}
	
}
