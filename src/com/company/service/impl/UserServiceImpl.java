package com.company.service.impl;

import com.company.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public String getName(String name) {
        System.out.println("###enter getName method###");
        return name;
    }

    @Override
    public Integer getAge(int age) {
        System.out.println("###enter getAge method###");
        return age;
    }
}
