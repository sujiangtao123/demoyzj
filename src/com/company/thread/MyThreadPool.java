package com.company.thread;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;
import java.util.concurrent.*;

public class MyThreadPool {


    private static final BlockingQueue<Runnable> QUEUE =  new ArrayBlockingQueue(10){
//        @Override
        public boolean offer(Runnable r) {
            return super.offer((Runnable)Proxy.newProxyInstance(Thread.class.getClassLoader(), new Class[]{Runnable.class}, new MyTask(TRACE.get(), r)));
        }
    };


    private static final ThreadLocal<String> TRACE = new ThreadLocal<>();


    /**
     * 自定义任务包装
     */
    public static class MyTask implements InvocationHandler {

        private final String traceId;

        private final Runnable runnable;

        public String getTraceId() {
            return traceId;
        }

        public MyTask(String traceId, Runnable runnable){
            this.traceId = traceId;
            this.runnable = runnable;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            TRACE.set(traceId);
            try {
                return method.invoke(runnable, args);
            }finally {
                TRACE.remove();
            }
        }
    }

    public static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(1, 10, 10, TimeUnit.SECONDS, QUEUE, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            r = (Runnable)Proxy.newProxyInstance(Thread.class.getClassLoader(), new Class[]{Runnable.class}, new MyTask(TRACE.get(), r));
            return new Thread(r);
        }
    });

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

//    for (int i = 0; i < 10; i++) {
        String traceId = UUID.randomUUID().toString().replace("-","");
        System.out.println(Thread.currentThread().getId() + "=========" + traceId);
        //1.主线程先set一个traceId
        TRACE.set(traceId);
        //4.提交任务到线程池
//      EXECUTOR.execute(() -> System.out.println(Thread.currentThread().getId() + "========" + TRACE.get()));

        Callable<String> callable = () -> {
            System.out.println(Thread.currentThread().getId() + "========" + TRACE.get());
            return TRACE.get();
        };
        System.out.println("0000000000");
        FutureTask<String> futureTask = new FutureTask<>(callable);

        EXECUTOR.submit(futureTask);
        System.out.println(futureTask.get());

//    }

    }


}

