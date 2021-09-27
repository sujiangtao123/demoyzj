package com.atguigu.chapter8.java2;

import com.company.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SonTest {


    public static void main(String[] args) {

        Father father = new Son();
        System.out.println(father.x);
    }
}

class Father {
    int x = 10;

    public Father() {
        this.print();
        x = 20;
    }

    public void print() {
        System.out.println("Father x= " + x);
    }

}

class Son extends Father {
    int x = 30;
    public Son() {
        this.print();
        x = 40;
    }

    public void print() {
        System.out.println("Son x= " + x);
    }

}