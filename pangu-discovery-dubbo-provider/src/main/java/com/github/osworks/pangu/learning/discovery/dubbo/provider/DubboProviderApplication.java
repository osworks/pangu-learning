package com.github.osworks.pangu.learning.discovery.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.github.osworks.pangu.common.boot.PanguApp;
import com.github.osworks.pangu.common.boot.PanguAppType;

@SpringBootApplication
@ComponentScan({"com.github.osworks.pangu"})
@EnableDubbo
public class DubboProviderApplication {

	public static void main(String[] args) {
		PanguApp.run(DubboProviderApplication.class, PanguAppType.WEBNONE, args);
	}

}
