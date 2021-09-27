package com.atguigu.chapter8;

public class EdenSurvivorTest {

    public static void main(String[] args) {
        System.out.println("我只是个打酱油的");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
