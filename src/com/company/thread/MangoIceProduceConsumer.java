package com.company.thread;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MangoIceProduceConsumer {
    //最多存放十杯芒果
    private final int MAX_SIZE = 10;

    private final LinkedList<MangoIce> mangoIceLinkedList = new LinkedList<>();

    class MangoIce {
    }

    //生产
    public void Produce() {
        while (true) {
            synchronized (mangoIceLinkedList) {
                if (mangoIceLinkedList.size() == MAX_SIZE) {
                    try {
                        //停止生产
                        mangoIceLinkedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mangoIceLinkedList.add(new MangoIce());
                System.out.println("[目前剩余的冰沙数目：]" + mangoIceLinkedList.size());
                //生产完成以后唤醒所有等待锁的线程
                mangoIceLinkedList.notifyAll();
                //线程休眠一会，给唤醒线程执行机会去消费
                try {
                    Thread.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费
    public void Consumer() {
        while (true) {
            synchronized (mangoIceLinkedList) {
                if (mangoIceLinkedList.size() == 0) {
                    try {
                        //等待去生产
                        mangoIceLinkedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mangoIceLinkedList.remove();
                System.out.println("[目前消费以后冰沙数目：]" + mangoIceLinkedList.size());
                mangoIceLinkedList.notifyAll();
                try {
                    Thread.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MangoIceProduceConsumer mangoIceProduceConsumer = new MangoIceProduceConsumer();
        for (int i = 0; i < 10; i++) {
            executorService.submit(mangoIceProduceConsumer::Produce);
            executorService.submit(mangoIceProduceConsumer::Consumer);
        }
    }
}
