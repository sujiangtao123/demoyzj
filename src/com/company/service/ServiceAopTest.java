package com.company.service;

import com.company.service.impl.UserServiceImpl;
import com.company.service.invoke.UserProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ServiceAopTest {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        UserProxy userProxy = new UserProxy(userService);
        UserService service = (UserService) userProxy.getProxy();
        System.out.println(service.getName("苏江涛"));

    }
}
