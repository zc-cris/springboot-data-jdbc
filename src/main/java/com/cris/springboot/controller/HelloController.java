package com.cris.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
    * @Author zc-cris
    * @Description 测试从阿里云服务器的Docker中的mysql服务中获取数据并返回
    * @Param []
    * @return java.util.Map<java.lang.String,java.lang.Object>
    **/
    @GetMapping("/query")
    @ResponseBody
    public Map<String, Object> map(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select id, departmentName from department");
        return list.get(0);
    }
}
