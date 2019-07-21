package com.kenny.study.service.impl;

import com.kenny.study.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author kenny_peng
 * @created 2019/7/21 下午5:31
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据id查找用户
     * @param id    传入用户ID
     * @return
     */
    @Override
    public Object find(String id) {
        System.out.println(id+"============");
        int i = Integer.parseInt(id);
        String sql = "select * from student where id =" + i;
        Map<String,Object> map = jdbcTemplate.queryForMap(sql);
        return map;
    }
}
