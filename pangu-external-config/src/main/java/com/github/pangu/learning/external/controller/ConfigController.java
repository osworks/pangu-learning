package com.github.pangu.learning.external.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RefreshScope // 实时刷新
@RequestMapping("config")
public class ConfigController {

	@Value("${bankcard.id:''}")
	private String id;
	@Value("${bankcard.name:''}")
	private String name;

	@GetMapping("user")
	public String user() {
		String outString = StrUtil.format("卡号: {}，姓名: {}", id, name);
		log.debug(outString);
		return outString;
	}
}
