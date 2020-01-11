package com.github.pangu.learning.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.pangu.learning")
public class PanguMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PanguMybatisApplication.class,args);
	}

}
