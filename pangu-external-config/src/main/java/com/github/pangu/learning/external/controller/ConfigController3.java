package com.github.pangu.learning.external.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pangu.learning.external.service.UserService;
import cn.hutool.core.util.StrUtil;

@RestController
@RequestMapping("config3")
public class ConfigController3 {
	
    @Autowired
    private UserService userService;

	@GetMapping("user")
	public String user() {
		String outString = StrUtil.format("卡号: {}，姓名: {}", userService.getId(), userService.getName());
		return outString;
	}
}
