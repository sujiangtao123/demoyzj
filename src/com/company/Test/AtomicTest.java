package com.company.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    private BigDecimal money;
    public static void main(String[] args) {
        AtomicTest atomicTest = new AtomicTest();
        AtomicInteger atomicInteger = new AtomicInteger(0);
//        System.out.println(atomicInteger.getAndAdd(5));
        System.out.println(atomicInteger.addAndGet(5));
        System.out.println(LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MIN));
//        atomicTest.method2();

    }

    public void method1() {
        for (int i = 0; i < 2; i++) {
            money = new BigDecimal(0);
        }

    }

    public void method2() {
        for (int i = 0; i < 2; i++) {
            BigDecimal money = new BigDecimal(0);
            System.out.println(555);
        }

    }
}
