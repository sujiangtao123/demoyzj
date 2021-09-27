package com.atguigu.chapter5;

import java.util.Date;

public class LocalVariablesTest {

    private static int sum = 1;
    private int count;

    public static void main(String[] args) {
        System.out.println("sujiangtao");

    }

    public static void testStatic(String name) {
        LocalVariablesTest localVariablesTest = new LocalVariablesTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);

    }

    //实例方法
    public void method() {
        count++;
        System.out.println(count);
    }


    private void slotTest() {
        int a = 0;
        {
            int b = 1;
            b = a + 1;
        }
        int c = a + 2;
    }
    private void foo(int a) {
        int b = 0;
        if(a ==2){
            int c = 3;
        }
    }
}
