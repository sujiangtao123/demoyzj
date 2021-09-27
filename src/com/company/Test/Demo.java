package com.company.Test;

import com.company.Enum.Product;
import com.company.Enum.ReturnCode;
import com.company.model.User;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
private static final String aa = "w";

private static int v = 5;
    public static void main(String[] args) throws Exception {

        String sujiangtao = null;
        String decode = null;
        try {
            sujiangtao = URLEncoder.encode("苏江涛1106-03");
//            System.out.println(sujiangtao);
            decode = URLDecoder.decode(sujiangtao, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        System.out.println(decode);
        List<Integer> list = Collections.synchronizedList(new ArrayList(0));
        List<Integer> list2 = Collections.synchronizedList(new ArrayList(0));
        List<LocalDateTime> list3 = Collections.synchronizedList(new ArrayList(0));
        Collections.addAll(list3, LocalDateTime.now());
        Collections.addAll(list2, 4, 4, 11, 11, 17, 26);
        List<LocalDateTime> collect = list3.stream().sorted(Comparator.comparing(LocalDateTime::toLocalDate)).collect(Collectors.toList());
        System.out.println(collect);
//        System.out.println(integer);
        //list.stream().skip(2).limit(10).forEach(System.out::println);
        //System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Date from = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date from1 = Date.from(LocalDate.now().atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
        System.out.println(from1);
        System.out.println(from);
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(from));
        System.out.println(new BigDecimal(-1).movePointLeft(3));
//        System.out.println(LocalDate.now().atStartOfDay());
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

//        Integer integer1 = list2.stream().filter(num -> num % 2 != 0).min(Comparator.comparing(Integer::intValue))
//                .orElse(null);
//        Iterator<Integer> iterator = list2.iterator();
//        while (iterator.hasNext()){
//            if(iterator.next() == integer1){
//                iterator.remove();
//            }
//
//        list2.forEach(System.out::println);
//        Pattern pattern = Pattern.compile("[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])\\s+(20|21|22|23|[0-1]\\d):[0-5]\\d:[0-5]\\d");
//        boolean matches = pattern.matcher("2014-01-01 12:00:00").matches();
//        System.out.println(matches);
//        list.stream().map(Integer::longValue).collect(Collectors.joining("/","/",""))
//        System.out.println(LocalDateTime.ofEpochSecond(1608782350L, 0,
//                ZoneOffset.ofHours(8)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Integer count2 = list.stream().reduce(2, (x, y) -> (x - y));
        System.out.println(count2);

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> reduce = list.stream().reduce(arrayList, (acc, item) -> {
            acc.add(item);
            return acc;
        }, (acc, item) -> null);
        System.out.println(arrayList);

        Map<String,String> map = new HashMap<>();
        map.put("key2","苏江涛");
        Collection<String> values = map.values();
//         map.computeIfAbsent("key", e -> "hello");
//        map.computeIfPresent("key2",(e,v)-> "null");
//        map.putIfAbsent("key3","你好啊");
//        String orDefault = map.getOrDefault("key3", "你好啊");
//        map.merge("key2","你好啊",(e,v)->null);
//        map.computeIfAbsent("key2",e->"你好啊");
//        System.out.println(map);
//        int j = 2;
//        List<BigDecimal> cost = new ArrayList<>();
//        BigDecimal  bigDecimal = new BigDecimal(0);
//        if(j >0){
//            cost.add(BigDecimal.valueOf(1));
//        }
//        if(j >1){
//            cost.add(BigDecimal.valueOf(2));
//        }
//        System.out.println(cost.stream().reduce(bigDecimal, BigDecimal::add, (acc, item) -> null));
//        System.out.println(cost.stream().reduce(bigDecimal, (acc, item) -> {
//            acc = acc.add(item);
//            return acc;
//        }));

        List<CompletableFuture> completableFutures = new ArrayList<>();
//        long l = System.currentTimeMillis();
//            for(int m = 0; m<10000; m++){
//                int finalM = m;
//                CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
//                    return getV(finalM);
//                }, Executors.newFixedThreadPool(10));
//                completableFutures.add(integerCompletableFuture);
//            }
//        try {
//           CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()])).get();
//        } catch (Exception e) {
//            System.out.println(4545);
//        }
//        long ll = System.currentTimeMillis();
//        System.out.println((ll - l) / 1000);
//        System.out.println(completableFutures.stream().mapToInt(complet -> {
//            try {
//                return Integer.parseInt(String.valueOf(complet.get()));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return 0;
//        }).sum());
        User u = new User("sujiangtai","nan");
        List<Integer> asll= new ArrayList<>();
        Collections.addAll(asll,1,2,3,4,5,6,7,8,9,10);
        List<Integer> sss= Collections.synchronizedList(new ArrayList<>());
        List<User> users= Collections.synchronizedList(new ArrayList<>());
        Map<Integer,Integer> mapp =new ConcurrentHashMap<>();
        Map<Integer,Integer> map1 =new ConcurrentHashMap<>();
        map1.put(11,2);map1.put(12,3);map1.put(13,4);
        long l = System.currentTimeMillis();
        asll.stream().forEach(s->{
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
//                int v = getV(s);
//                System.out.println(map1.get(v));
//                sss.add(v);
//                mapp.put(s,v);
                u.setAge(s.toString());
                System.out.println(u.getAge());
                users.add(u);

            }, Executors.newFixedThreadPool(10));
            completableFutures.add(voidCompletableFuture);
        });
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()])).join();

        long ll = System.currentTimeMillis();
        System.out.println((ll - l) / 1000);
        System.out.println(mapp);
        System.out.println(sss);
        users.stream().forEach(s-> System.out.println(s.getAge()));
    }


    private static  int getV(int m){
        try {
            Thread.sleep(2);
            LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  m +10;
    }



    }

