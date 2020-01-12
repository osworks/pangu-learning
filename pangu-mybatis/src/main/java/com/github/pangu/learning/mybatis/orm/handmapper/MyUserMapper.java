package com.github.pangu.learning.mybatis.orm.handmapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pangu.learning.mybatis.orm.entity.User;

/**
 * 自定义sql手工映射
 */
public interface MyUserMapper {
    
    Page<User> mySelectPageByMap(Page<User> page, @Param("map") Map<String, Object> param);
    
    Page<Map<String, Object>> mySelectPageByMap2(Page<Map<String, Object>> page, @Param("map") Map<String, Object> param);

    List<User> mySelectByMap(Map<String, Object> param);
}
