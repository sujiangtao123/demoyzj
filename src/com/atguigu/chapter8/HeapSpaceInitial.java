package com.atguigu.chapter8;

import java.util.Random;

public class HeapSpaceInitial {
    public static void main(String[] args) {

        //java堆内存的初始大小
        Long initialSpace = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        //最大堆内存
        Long maxSpace = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms " + initialSpace + "M");
        System.out.println("-Xmx " + maxSpace + "M");
        System.out.println("系统内存大小: " + initialSpace * 64 / 1024 + "G");
        System.out.println("系统内存大小: " + maxSpace * 4 / 1024 + "G");
//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(new Random().nextInt(10));
    }

}
