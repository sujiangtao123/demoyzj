package com.atguigu.charater1;

public class StackStruTest {

private static int num = 1;
static {
    num = 2;
}
    public static void main(String[] args) {

        System.out.println(StackStruTest.num);
        a();
        b();
        new Thread(()->{
            a();
            b();
        }).start();

    }

    public static void a(){
        System.out.println("方法a的...."+Thread.currentThread().getName());
    }
    public static void b(){
        System.out.println("方法b的...."+Thread.currentThread().getName());
    }

}
