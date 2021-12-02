package com.company.thread.safe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThredPoolTest {
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.DiscardOldestPolicy());

    private final static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {
         for (int i = 0; i < 3;i++){
//             Task task = new Task(i);
//             Future<?> submit = threadPoolExecutor.submit(task);
//             try {
//                 Object o = submit.get();
//             } catch (Exception e) {
//                 System.out.println(e.getCause());
//             }
             int finalI = i;
                 threadPoolExecutor.submit(()->{
                     try {
                         int n = 1 / 0 ;
                         System.out.println("Task"+ finalI +"........");
                     } catch (Exception e) {
                         System.out.println("异常了");
                         e.printStackTrace();
                     }
                     countDownLatch.countDown();
                 });
         }
        threadPoolExecutor.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("都执行完成了");
    }

}
//class Task implements Runnable{
//    private int i;
//    public Task(int i){
//        this.i = i;
//    }
//
//    @Override
//    public void run() {
//        int n = 1 / 0 ;
//        System.out.println("Task"+i+"........");
//    }
//}
