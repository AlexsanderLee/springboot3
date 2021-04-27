package com.lsq.springboot.springboottest.controller;


import com.lsq.springboot.springboottest.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("page")
public class PageController {


    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("username","lsq");
        User user = new User("lsq","222");
        model.addAttribute("user",user);
        model.addAttribute("money",100);
        List<User> list= new ArrayList<>();
        list.add(new User("zhang","22"));
        list.add(new User("lisi","22"));
        model.addAttribute("list",list);
        model.addAttribute("now",new Date());
        return "hello";
    }
}
