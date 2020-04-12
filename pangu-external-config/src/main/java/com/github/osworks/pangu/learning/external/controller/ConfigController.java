package com.github.osworks.pangu.learning.external.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("config")
public class ConfigController {

	@NacosValue(value = "${bankcard.id}", autoRefreshed = true)
	private String id;
	@NacosValue(value = "${bankcard.name}", autoRefreshed = true)
	private String name;

	@GetMapping("user")
	public String user() {
		String outString = StrUtil.format("卡号: {}，姓名: {}", id, name);
		log.debug(outString);
		return outString;
	}
}
