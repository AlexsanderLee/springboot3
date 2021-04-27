package com.lsq.springboot.springboottest.interceptor;

import com.lsq.springboot.springboottest.config.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class MyInterceptor implements HandlerInterceptor {


    @Autowired
    private Resource resource;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        System.out.println("MyInterceptor preHandle...");
        System.out.println(resource.getEmailServer());
        return true;
    }
}
