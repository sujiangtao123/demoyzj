package com.company.service.invoke;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy implements InvocationHandler {

    //目标类，被代理的对象
    private Object obj;
    public UserProxy(Object obj){
        this.obj = obj;
    }
    //生成代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("###enter invoke method pre###");
        Object result = method.invoke(obj, args);
        System.out.println("###enter invoke method after###");
        return result;
    }
}
