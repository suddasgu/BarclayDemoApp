package com.barclay.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.barclay.demo")
public class BarclayDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarclayDemoAppApplication.class, args);
	}
}
