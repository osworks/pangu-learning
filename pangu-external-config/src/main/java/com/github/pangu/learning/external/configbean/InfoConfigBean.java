package com.github.pangu.learning.external.configbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@RefreshScope
@Component
public class InfoConfigBean {
	
	@Value("${bankcard.id:''}")
	private String id;
	
	@Value("${bankcard.name:''}")
	private String name;
	
}
