package com.github.osworks.pangu.learning.external.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.osworks.pangu.learning.external.orm.entity.User;
import com.github.osworks.pangu.learning.external.service.UserService;
import com.github.osworks.pangu.toolbox.util.Asserts;

@RestController
@RequestMapping("config3")
public class ConfigController3 {
	
    @Autowired
    private UserService userService;

	@GetMapping("user")
	public User user(Long id) {
	    Asserts.notNull(id, "参数id不能为空");
		User user = userService.getUserInfo(id);
		return user;
	}
}
