package com.atguigu.chapter8.java2;

import org.junit.Test;
import org.omg.IOP.ComponentIdHelper;

public class IntegerTest {
    public static void main(String[] args) {
        Integer x = 5;
        int y =5;
        System.out.println(x == y);

        Integer x1 = 10;
        Integer x2 = 10;
        System.out.println(x1 == x2);
        Integer x3 = 128;
        Integer x4 = 128;
        System.out.println(x3 == x4);


    }


    @Test
    public void constValue(){
       int i = 10;
       double j = 10 / 0.0;
        System.out.println(j);
    }
    @Test
    public void method2(){
     int i = 1;
     i = ++i;
     System.out.println(i);
    }


}
