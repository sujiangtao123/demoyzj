package com.company.thread;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreTest {
    private static int quest_count = 100;

    private static int concurrent_count = 50;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(concurrent_count);
        CountDownLatch countDownLatch = new CountDownLatch(quest_count);
        for (int i = 0; i < quest_count; i++) {
            executorService.submit(() -> {
                try {
                    if (semaphore.availablePermits() == 0) {
                        System.out.println("车位不足，请耐心等待");
                    }
                    //获取锁执行
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "成功进入停车场");
                    add();
                    //模拟车在里面时间
                    Thread.sleep(new Random().nextInt(1000));
                    System.out.println(Thread.currentThread().getName() + "驶出停车场");
                    semaphore.release();
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count=  " + atomicInteger);
    }

    private static void add() {
        atomicInteger.incrementAndGet();
    }
}
