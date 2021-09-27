package com.atguigu.chapter5;

/**
 * 栈帧测试
 */
public class StackFrameTest {

    public static void main(String[] args) {
        StackFrameTest stackFrameTest = new StackFrameTest();
        System.out.println("main开始执行");
        stackFrameTest.method1();
        System.out.println("main执行结束");
    }

    private void method1(){
        System.out.println("method1开始执行");
        method2();
        System.out.println("method1执行结束");
        System.out.println(10 /0);
    }

    private void method2(){
        System.out.println("method2开始执行");
        method3();
        System.out.println("method2执行结束");

    }
    private void method3(){
        System.out.println("method3开始执行");
        System.out.println("method3执行结束");
    }
}
