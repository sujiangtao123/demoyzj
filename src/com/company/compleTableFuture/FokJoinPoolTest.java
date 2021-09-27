package com.company.compleTableFuture;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FokJoinPoolTest {
    public static void main(String[] args) {
        // 并行流 多个线程执行
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        numbers.parallelStream()
//                .forEach(System.out::print);
        CopyOnWriteArrayList<Integer> objects = new CopyOnWriteArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i <10; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    int m = 1 / 0;
                    objects.add(finalI);
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + "----"+"执行出错");
                }
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "----"+"执行完成进行减1");
            });
        }
        try {
            countDownLatch.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(objects);

    }
}
