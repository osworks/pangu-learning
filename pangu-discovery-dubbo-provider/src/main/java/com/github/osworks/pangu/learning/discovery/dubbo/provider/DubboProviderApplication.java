package com.github.osworks.pangu.learning.discovery.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.github.osworks.pangu.common.boot.PanguApp;
import com.github.osworks.pangu.common.boot.PanguAppType;

@SpringBootApplication
@ComponentScan({"com.github.osworks.pangu"})
@EnableDubbo
@NacosPropertySource(dataId = "${nacos.config.data-id}", autoRefreshed = true)
public class DubboProviderApplication {

	public static void main(String[] args) {
		PanguApp.run(DubboProviderApplication.class, PanguAppType.WEBNONE, args);
	}

}
