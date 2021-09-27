package com.company.service;

import com.company.service.impl.UserServiceImpl;
import com.company.service.invoke.UserProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ServiceAopTest {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        InvocationHandler userProxy = new UserProxy(userService);
//        UserService service = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader()
//                , userService.getClass().getInterfaces(), userProxy);
        UserService service = (UserService)Proxy.newProxyInstance(userProxy.getClass().getClassLoader()
                , userService.getClass().getInterfaces(), userProxy);
        System.out.println(service.getName("苏江涛"));

    }
}
