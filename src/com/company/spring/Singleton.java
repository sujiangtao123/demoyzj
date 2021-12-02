package com.company.spring;

import java.lang.reflect.Field;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Singleton {
    //懒汉式单例
    private static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) throws Exception {
        long time2 = System.currentTimeMillis() / 1000;
        System.out.println(time2);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli() / 1000);

        System.out.println(df.format(LocalDateTime.ofInstant(Instant.ofEpochSecond(0), ZoneId.of("Asia/Shanghai"))));
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
    }
}
