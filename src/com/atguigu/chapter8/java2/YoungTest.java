package com.atguigu.chapter8.java2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class YoungTest {
    public static void main(String[] args) {
//        byte[] bate = new byte[1024 * 1024 * 20];
        LocalDateTime.parse("20210412152832", DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    }
}
