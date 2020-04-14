package com.github.osworks.pangu.learning.external;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.github.osworks.pangu.common.boot.PanguApp;
import com.github.osworks.pangu.common.boot.PanguAppType;

@SpringBootApplication
@ComponentScan({"com.github.osworks.pangu"})
public class ConfigApplication {

	public static void main(String[] args) {
	    PanguApp.run(ConfigApplication.class, PanguAppType.WEBSERVLET, args);
	}

}
