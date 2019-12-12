package com.nationwide.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import name.christophperrins.users.general.Application;

@SpringBootApplication
@ComponentScan(basePackageClasses = {Application.class, ProductApplication.class})
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}
