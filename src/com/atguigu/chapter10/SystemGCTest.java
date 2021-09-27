package com.atguigu.chapter10;

import java.lang.reflect.Field;
import java.util.Random;

public class SystemGCTest {

    public static void main(String[] args)  throws Exception{

        final String s ="hello word";
        Field value = s.getClass().getDeclaredField("value");
        value.setAccessible(true);
         char[] ss = (char[]) value.get(s);
        ss[0] ='a';
        System.out.println(s);
        System.out.println("s="+s);
    }
}
