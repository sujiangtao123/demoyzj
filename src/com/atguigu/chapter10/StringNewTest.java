package com.atguigu.chapter10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringNewTest {

    public static void main(String[] args) {
        /**
         * 一共创建6个对象,因为有连接符号，所以会有
         * 1.new stringBuilder()
         * 2.new String("a")
         * 3.字符串常量池中"a"
         * 4.new String("b")
         * 5.字符串常量池中"b"
         * 6.toString方法中会有new String()
         */
        String str = new String("a")+ new String("b");
    }
}
