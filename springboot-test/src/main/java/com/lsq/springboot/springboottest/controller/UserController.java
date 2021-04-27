package com.lsq.springboot.springboottest.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsq.springboot.springboottest.config.Resource;
import com.lsq.springboot.springboottest.entity.User;
import com.lsq.springboot.springboottest.pojo.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {


    @Autowired
    private Resource resource;

    @GetMapping("getImageServer")
    public String getImageServer() {
        return resource.getImageServer();
    }


    @GetMapping("get")
    public ResultBean add(@Valid User user) throws JsonProcessingException {
        log.info("模拟用户输出");
        return new ResultBean("success","ok");
    }
}
