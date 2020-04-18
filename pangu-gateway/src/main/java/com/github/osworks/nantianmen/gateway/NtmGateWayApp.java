package com.github.osworks.nantianmen.gateway;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import com.github.osworks.pangu.common.boot.PanguApp;
import com.github.osworks.pangu.common.boot.PanguAppType;

@SpringBootApplication
@EnableDubbo
@ServletComponentScan(basePackages = "com.github.osworks.nantianmen.gateway")
@ComponentScan({"com.github.osworks"})
public class NtmGateWayApp {

    public static void main(String[] args) {
        PanguApp.run(NtmGateWayApp.class, PanguAppType.WEBSERVLET, args);
    }

}
