package com.github.pangu.learning.discovery.dubbo.provider;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DubboProviderApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DubboProviderApplication.class, args);
	    new SpringApplicationBuilder(DubboProviderApplication.class).web(WebApplicationType.NONE).run(args);
	}

}
