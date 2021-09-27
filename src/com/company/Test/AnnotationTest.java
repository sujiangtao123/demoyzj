package com.company.Test;

import com.company.thread.MyLog;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTest {



    private static String username;
    private String password;

    @MyLog
    public void getUsername(String name, int age){
        System.out.println(name+age);
    }

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.company.Test.AnnotationTest");
        Class<AnnotationTest> annotationTestClass = AnnotationTest.class;
        //获取本类的所有声明字段
        Field[] declaredFields = annotationTestClass.getDeclaredFields();
        //获取所有的声明方法
        Method[] declaredMethods = annotationTestClass.getDeclaredMethods();
        AnnotationTest annotationTest = annotationTestClass.newInstance();
//        Method getUsername = annotationTestClass.getDeclaredMethod("getUsername", String.class);
        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.getName().equals("getUsername")){
                MyLog annotation = declaredMethod.getAnnotation(MyLog.class);
                Object arg[] = {annotation.description(),20};
                //newInstance 需要实例化
                declaredMethod.invoke(annotationTest,arg);
            }
        }
        for (Field declaredField : declaredFields) {
            if(declaredField.isAnnotationPresent(MyLog.class)){
                MyLog annotation = declaredField.getAnnotation(MyLog.class);
                System.out.println(annotation.description());
            }
        }

    }
}
