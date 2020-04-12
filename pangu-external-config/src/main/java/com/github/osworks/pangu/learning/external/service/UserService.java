package com.github.osworks.pangu.learning.external.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.osworks.pangu.learning.external.orm.entity.User;
import com.github.osworks.pangu.learning.external.orm.mapper.UserMapper;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    public User getUserInfo(Long id) {
        User user =  userMapper.selectById(id);
        log.debug(JSONUtil.toJsonStr(user));
        return user;
    }
}
