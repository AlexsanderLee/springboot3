package com.lsq.springboot.springboottest.entity;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class User {



    @NotNull(message = "姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(@Valid String  name, @Valid String age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}
