package com.company.compleTableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompleTableFutureTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始进行");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompleTableFutureTest::fetchPrice);
            Double aDouble = cf.get();
            System.out.println(aDouble);
        } catch (Exception e) {
            //e.printStackTrace();
            String s = aVoid();
            System.out.println(s);
        }

//        cf.thenAccept((result)->{
//            System.out.println("price: "+result);
//            t.setA(result);
//            System.out.println(t.getA());
//        });

        System.out.println("开始结束");
        //Thread.sleep(1000);
//        String s = aVoid();
//        System.out.println(s);
        //Thread.currentThread().join();
    }
    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
    static  String aVoid(){
        return "任务出错...";
    }
}
