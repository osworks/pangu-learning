package com.github.pangu.learning.external.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pangu.learning.external.orm.entity.User;
import com.github.pangu.learning.external.service.UserService;

@RestController
@RequestMapping("config4")
public class ConfigController4 {
	
    @Autowired
    private UserService userService;

	@GetMapping("user")
	public User user(Long id) {
		User user = userService.getUserInfo(id);
		return user;
	}
}
