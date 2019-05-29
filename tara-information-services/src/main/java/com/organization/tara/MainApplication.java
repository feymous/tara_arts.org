package com.organization.tara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {"com.organization.tara.controller", "com.organization.tara.repository" ,"com.organization.tara.service", "com.organization.tara.service.impl"})
public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MainApplication.class, args);
	}

}
