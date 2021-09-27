package com.atguigu.chapter4;


public class PCRegisterTest {

    public static final String value = "3";

    static {
        System.out.println("Super Class Init!");
    }
}

    class SubClass extends PCRegisterTest {
        static {
            System.out.println("Sub Class Init!");
        }
    }

    class c {
        public static void main(String[] args) {
            System.out.println(SubClass.value);
        }
    }

