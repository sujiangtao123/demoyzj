package com.atguigu.chapter10.java3;

public class ThreadDeadTest {

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        new Thread(()->{

            synchronized (s1){
                s1.append(1);
                s2.append(2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s2){
                    s1.append(1);
                    s2.append(2);
                }
            }
        }).start();
        new Thread(()->{

            synchronized (s2){
                s1.append(1);
                s2.append(2);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s1){
                    s1.append(1);
                    s2.append(2);
                }
            }
        }).start();
    }
}
