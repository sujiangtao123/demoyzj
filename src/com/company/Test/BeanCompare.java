package com.company.Test;

import com.company.model.User;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class BeanCompare {
    public static void main(String[] args) throws Exception {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("222");
        ArrayList<String> objects1 = new ArrayList<>();
        objects1.add("333");
        User user =  new User("小红","男","22",objects);
        User user1 =  new User("小明","男","23",objects1);
        compare(user,user1);
    }

    public static void compare(Object ob1,Object ob2) throws Exception {
        if(ob1 instanceof User && ob2 instanceof User){
            User user = (User)ob1;
            User user1 = (User)ob2;
            Class<? extends User> aClass = user.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(declaredField.getName(),aClass);
                Method readMethod = propertyDescriptor.getReadMethod();
                Object invoke = readMethod.invoke(user);
                Object invoke1 = readMethod.invoke(user1);
                String s1 = invoke == null ? "" : invoke.toString();//避免空指针异常
                String s2 = invoke1 == null ? "" : invoke1.toString();//避免空指针异常
                if(!s1.equals(s2)){
                    System.out.println(s1+s2);
                }
            }
        }
    }

}
