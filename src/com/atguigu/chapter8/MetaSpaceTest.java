package com.atguigu.chapter8;

public class MetaSpaceTest {

    public static void main(String[] args){
        Order order = null;
        order.test();
        System.out.println(order.count);
    }
}

class Order{
    public static int count = 1;
    public static final int num = 2;

    public static void test(){
        System.out.println("hello");
    }
}
