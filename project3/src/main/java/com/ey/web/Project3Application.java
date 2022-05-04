package com.ey.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ey.web.controller","com.ey.web.entity","com.ey.web.dao"})
public class Project3Application {

	public static void main(String[] args) {
		SpringApplication.run(Project3Application.class, args);
	}
}