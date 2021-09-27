package com.company.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal=new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("苏江涛");
        new Thread(()->{
            System.out.println("子线程thread中的本地变量值:"+threadLocal.get());
        }).start();
        System.out.println("main线程中的本地变量值:"+threadLocal.get());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse=null;
        try {
            parse = sdf.parse("2020-01-21 11:45:12");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(parse);
    }
}
