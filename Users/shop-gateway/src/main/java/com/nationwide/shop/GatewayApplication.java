package com.nationwide.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import name.christophperrins.users.general.Application;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackageClasses = {Application.class, GatewayApplication.class})
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
