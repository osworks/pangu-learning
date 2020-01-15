package com.github.pangu.learning.mybatis;

import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pangu.learning.mybatis.orm.entity.User;
import com.github.pangu.learning.mybatis.orm.handmapper.MyUserMapper;
import com.github.pangu.learning.mybatis.orm.mapper.UserMapper;
import com.github.pangu.toolbox.util.Maps;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaginationTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MyUserMapper myUserMapper;

    @Test
    public void page1() {
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPage(page, Wrappers.<User>lambdaQuery().ge(User::getAge, 1).orderByAsc(User::getAge));
        System.out.println(page.getTotal());
        page.getRecords().forEach(System.out::println);
    }

    @Test
    public void page2() {
        Page<Map<String, Object>> page = new Page<>(1, 3);
        userMapper.selectMapsPage(page, Wrappers.<User>lambdaQuery().select(User::getName, User::getId).ge(User::getAge, 1).orderByAsc(User::getAge));
        System.out.println(page.getTotal());
        page.getRecords().forEach(System.out::println);
    }
    
    @Test
    public void page3() {
        Page<User> page = new Page<>(1, 2);
        Map<String, Object> inMap = Maps.newHashMap();
        inMap.put("name", "XC");
        myUserMapper.mySelectPageByMap(page, inMap);
        System.out.println(page.getTotal());
        page.getRecords().forEach(System.out::println);
    }
    
    @Test
    public void page4() {
        Page<Map<String, Object>> page = new Page<>(1, 2);
        Map<String, Object> inMap = Maps.newHashMap();
        inMap.put("name", "XC");
        myUserMapper.mySelectPageByMap2(page, inMap);
        System.out.println(page.getTotal());
        page.getRecords().forEach(System.out::println);
    }
    
    

}
