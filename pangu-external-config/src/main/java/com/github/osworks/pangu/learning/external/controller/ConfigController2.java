package com.github.osworks.pangu.learning.external.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.osworks.pangu.learning.external.configbean.InfoConfigBean;
import cn.hutool.core.util.StrUtil;

@RestController
@RequestMapping("config2")
public class ConfigController2 {
	
	@Autowired
	private InfoConfigBean infoConfigBean;

	@GetMapping("user")
	public String user() {
		String outString = StrUtil.format("卡号: {}，姓名: {}", infoConfigBean.getId(), infoConfigBean.getName());
		return outString;
	}
}
