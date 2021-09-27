package com.atguigu.chapter10.java3;

import com.company.model.User;
import com.sun.deploy.util.SyncAccess;
import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ScannerTest {
    public static void main(String[] args) throws InterruptedException {
//        ArrayList<byte[]> bytes = new ArrayList<>();
//        bytes.add(1);
//        while (true){
//            byte[] bytes1 = new byte[1024 * 100];
//            bytes.add(bytes1);
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        User user = new User("qqq","222");
//        aVoid(user);
//        System.out.println(user);
//        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
        List<Integer> list = new ArrayList<>();

        LocalDateTime.parse("2021-04-02 10:02:50", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(BigDecimal.valueOf(6).divide(BigDecimal.valueOf(11), 4, BigDecimal.ROUND_HALF_UP));
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
        aVoid(list);
    }

private static void aVoid( List<Integer> list){

    list.stream().forEach(ScannerTest::a);
}
    private static void a(Integer i){

        System.out.println(i);
        if(i == 4){
            return;
        }
    }
}
