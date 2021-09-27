package com.company.thread;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static final Lock lock = new ReentrantLock();

    public static void add2(int n) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +"程序开始");
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() +"我得到锁进来了");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() +"我执行完毕");
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() +"我释放锁了");
            }
        }else {
            System.out.println(Thread.currentThread().getName()+"我在等待");
        }
    }

    public static void main(String[] args) {
        new Thread(()-> {
            try {
                add2(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()-> {
            try {
                add2(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();

    }
}
