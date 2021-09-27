package com.company.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintThread {
//    private final static Object object = new Object();
    private final static Lock lock = new ReentrantLock();
    private static Condition provider = lock.newCondition();
    public static void main(String[] args) {
        new Thread(()->{
//            synchronized (object){
            try {
                lock.lock();
                for (int i = 1; i <=26; i++){
                    System.out.println(i);
                    provider.signal();
                    try {
                        //轻微睡眠给另一个线程执行机会
                        Thread.sleep(1000);
                        provider.await();
                    }catch (Exception e){
                        System.out.println("error");
                    }
                }
            }catch (Exception e){
                lock.unlock();
            }
//            }
        }).start();
        new Thread(()->{
            try {
                lock.lock();
                for (int i = 1; i <=26; i++){
                    System.out.println((char) (i+64));
                    provider.signal();
                    try {
                        //轻微睡眠给另一个线程执行机会
                        Thread.sleep(1000);
                        provider.await();
                    }catch (Exception e){
                        System.out.println("error");
                    }
                }
            }catch (Exception e){
                lock.unlock();
            }
//            synchronized (object){
//            }
        }).start();
    }
}
