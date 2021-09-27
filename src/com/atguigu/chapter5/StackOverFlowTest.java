package com.atguigu.chapter5;


/**
 * 越栈的异常
 * jvm默认： 10413
 * 设置栈的大小以后：-Xss256K  2310 设置成功
 */
public class StackOverFlowTest {

    private static int count = 1;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
