package com.company.thread;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class AqsTest {
    static ReentrantLock reentrantLock = new ReentrantLock(false);
    private final static CountDownLatch countDownLatch = new CountDownLatch(10);
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        try {
//            threadLocal.set("22");
//            reentrantLock.lock();
//            countDownLatch.await();
            String ss = "asdfgh";
            System.out.println(ss.substring(0, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
