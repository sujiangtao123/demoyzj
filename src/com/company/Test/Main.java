package com.company.Test;

import com.company.model.CallSessionBean;
import com.company.model.User;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.zip.DeflaterOutputStream;

public class Main {


    public static void main(String[] args) {
        String ss = "www.baidu.com";
        String sss = "dsds";
        AtomicInteger atomicInteger = new AtomicInteger(0);
        //System.out.println(str.isBlank());//判断字符串是不是空白
        //System.out.println(str.lines().count());
        final int a = 3;
        AtomicReference<BigDecimal> multiply = new AtomicReference<>();
        BigDecimal bigDecimal = new BigDecimal(2);
        List<Integer> list = Collections.synchronizedList(new ArrayList(0));
        List<Integer> list1 = Collections.synchronizedList(new ArrayList(0));
        List<String> list2 = Collections.synchronizedList(new ArrayList(0));
        Collections.addAll(list, 1, 2, 3, 4, 5, 6);
        Collections.addAll(list1, 6, 7, 8, 9, 10);
        Collections.addAll(list2, "2", "7", "1", "5", "6");
        list.stream().forEach(s -> {
            if (1 == s) {
                multiply.set(BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(2)));

            }
        });
        System.out.println(multiply.get());
        System.out.println(LocalDateTime.parse("2017-12-20 10:22:22", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(ss.hashCode() % 1000);
        System.out.println(sss.hashCode() % 1000);
        String ll = "tt: 1245645";
        System.out.println(ll.indexOf(":"));
        System.out.println(ll.substring(ll.indexOf(":") + 1).trim());
        list.stream().skip(1).limit(10).forEach(System.out::println);
//        User user = new User("1", "2019-04-30 16:08:55", "5");
//        User user1 = new User("1", "2019-04-30 16:08:59", "5");
//        System.out.println(user.equals(user1));
        String date = "2019-04-30 16:08:55";
        String date1 = "2019-04-30 16:08:54";
        LocalDateTime parse = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime parse1 = LocalDateTime.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Instant instant = parse.toInstant(ZoneOffset.of("+8"));
        Instant instant1 = parse1.toInstant(ZoneOffset.of("+8"));
//        System.out.println(Math.abs(Duration.between(instant, instant1).toSeconds()));
        System.out.println(Duration.between(instant, instant1).toMillis());
        System.out.println(Math.abs((Long.parseLong("1") - Long.parseLong("6"))));
        if (atomicInteger.compareAndSet(0, 1)) {
            System.out.println(atomicInteger.get());
        }
        System.out.println(LocalDate.now().atStartOfDay());
        System.out.println(Instant.ofEpochMilli(System.currentTimeMillis()).atOffset(ZoneOffset.ofHours(8)).toLocalDateTime());
        System.out.println(LocalDate.now().isBefore(LocalDate.parse("2021-01-01",DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        String collect = list2.stream().collect(Collectors.joining(",", "|", "|"));
        System.out.println(collect);
//        for(;LocalDate.now().isBefore(LocalDate.parse("2021-01-01",DateTimeFormatter.ofPattern("yyyy-MM-dd")));){
//            System.out.println("sususususuus");
//        }
//        list.stream().forEach((s)->{
//            if (s.equals(1)){
//                System.out.println("1111111111111111");
//                return;
//            }
//            list1.stream().forEach((w)->{
//                System.out.println(w);
//            });
//        });

//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i)==1){
//                System.out.println("45455");
//                break;
//            }
//            System.out.println(list.get(i));
//        }
    }
}

