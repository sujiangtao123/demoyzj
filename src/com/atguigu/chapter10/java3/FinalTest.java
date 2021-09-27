package com.atguigu.chapter10.java3;

import org.junit.Test;

public class FinalTest {


    @Test
    public void method() {
        System.out.println(Son.num);
        try {
            Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.atguigu.chapter10.java3.father");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

class Son extends father {
    static {
        System.out.println("子类初始化");
    }
}

class father {

    public static final int num = 3;

    static {
        System.out.println("父类初始化");
    }
}
