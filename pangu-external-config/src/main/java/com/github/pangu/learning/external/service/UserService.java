package com.github.pangu.learning.external.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import com.github.pangu.learning.external.orm.entity.User;
import com.github.pangu.learning.external.orm.mapper.UserMapper;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RefreshScope
@Service
public class UserService {
    
    @Value("${bankcard.id:''}")
    private String id;
    @Value("${bankcard.name:''}")
    private String name;
    
    @Autowired
    private UserMapper userMapper;
    
    public User getUserInfo(Long id) {
        User user =  userMapper.selectById(id);
        log.debug(JSONUtil.toJsonStr(user));
        return user;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
}
