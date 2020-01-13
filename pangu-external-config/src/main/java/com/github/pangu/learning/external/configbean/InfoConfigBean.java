package com.github.pangu.learning.external.configbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//这种方式不能实时刷新
@Component
public class InfoConfigBean {
	
	@Value("${bankcard.id:''}")
	public String id;
	
	@Value("${bankcard.name:''}")
	public String name;
	
}
