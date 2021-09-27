package com.company.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallAble implements Callable<String> {
    private String name;
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return name;
    }
    public MyCallAble(String name){
        this.name=name;
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Callable<String>> list=new ArrayList<>();
        list.add(new MyCallAble("小红"));
        list.add(new MyCallAble("小明"));
        list.add(new MyCallAble("小李"));
        list.add(new MyCallAble("小旺"));
        List<Future<String>> futureList = executorService.invokeAll(list);
        futureList.forEach((s)-> {
            try {
                System.out.println(s.get(2,TimeUnit.SECONDS));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
     }
}



