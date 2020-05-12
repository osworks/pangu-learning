package com.github.pangu.learning.mybatis;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pangu.learning.mybatis.orm.entity.User;
import com.github.pangu.learning.mybatis.orm.mapper.UserMapper;
import com.github.pangu.toolbox.util.Maps;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudDataBaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void aInsert() {
        User user = new User();
        user.setId(100L).setAge(10).setClassId(1L).setEmail("307916217@qq.com").setName("熊春");
        userMapper.insert(user);
    }

    @Test
    public void aUpdate() {
        userMapper.updateById(new User().setId(1L).setAge(10));
        userMapper.update(new User().setAge(10), Wrappers.<User>lambdaUpdate().set(User::getEmail, null).eq(User::getClassId, 1L));
        userMapper.update(null, Wrappers.<User>lambdaUpdate().set(User::getEmail, "307916217@qq.com").eq(User::getId, 2L));
        userMapper.update(new User().setEmail("307916217@qq.com"), new QueryWrapper<User>().lambda().eq(User::getId, 1L));
        // userMapper.s
    }

    @Test
    public void aDelete() {
        userMapper.deleteById(1000L);
        userMapper.delete(new QueryWrapper<User>().lambda().eq(User::getName, "XC100"));
        userMapper.deleteBatchIds(Arrays.asList(101L, 102L));
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", 1000L);
        map.put("name", null);
        userMapper.deleteByMap(map);
        String nameString = "XC";
        userMapper.delete(new QueryWrapper<User>().lambda().eq(nameString != null, User::getName, nameString).eq(User::getId, 1000L));
    }

    @Test
    public void aOrderBy() {
        List<User> users = userMapper.selectList(Wrappers.<User>query().orderByDesc("id"));
        users.forEach(System.out::println);
    }

    @Test
    public void aSelect() {
        List<User> users = userMapper.selectList(Wrappers.<User>lambdaQuery().select(User::getName));
        users.forEach(System.out::println);
        List<User> users2 = userMapper.selectList(new QueryWrapper<User>().select("id, name").eq("name", "XC"));
        users2.forEach(System.out::println);
        List<User> users3 = userMapper.selectList(new QueryWrapper<User>().eq("name", "XC").between("age", 1, 100));
        users3.forEach(System.out::println);
    }

    @Test
    public void bSelectMaps() {
        List<Map<String, Object>> userMaps = userMapper.selectMaps(new QueryWrapper<User>().select("id,name").ge("age", 10));
        userMaps.forEach(System.out::println);
    }

    @Test
    public void cSelect() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
        User user2 = userMapper.selectOne(new QueryWrapper<User>().select("id, name").eq("id", 1L));
        System.out.println(user2);

        Integer countInteger = userMapper.selectCount(Wrappers.<User>query().eq("name", "XC"));
        System.out.println(countInteger);
    }

    @Test
    public void dSelectGroup() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("age, count(id) as cnt").groupBy("age");
        List<Map<String, Object>> maplist = userMapper.selectMaps(wrapper);
        maplist.forEach(System.out::println);
    }


}
