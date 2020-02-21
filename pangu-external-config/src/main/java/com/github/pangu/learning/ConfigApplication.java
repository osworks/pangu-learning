package com.github.pangu.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.pangu")
public class ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class,args);
	}

}
