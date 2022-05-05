package com.ey.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.ey.web.controller","com.ey.web.entity","com.ey.web.dao"})
public class Project3Application extends SpringBootServletInitializer {
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Project3Application.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(Project3Application.class, args);
	}
}
/*
@SpringBootApplication
@ComponentScan(basePackages = {"com.ey.web.controller","com.ey.web.entity","com.ey.web.dao"})
public class Project3Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Project3Application.class, args);
    }
}
*/