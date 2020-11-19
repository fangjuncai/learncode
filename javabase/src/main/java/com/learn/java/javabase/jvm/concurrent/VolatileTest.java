package com.learn.java.javabase.jvm.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-07-21 17:51
 **/
public class VolatileTest {
    private static volatile int counter = 0;

    private static void increase() {
        counter++;
    }

    private static final int MAX_NUM = 20;

    public static void main(String[] args) {
        //指定队列容量
        ExecutorService executorService = new ThreadPoolExecutor(MAX_NUM, MAX_NUM, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(MAX_NUM), new ThreadPoolExecutor.DiscardPolicy());

/*
            public LinkedBlockingQueue() {
            this(Integer.MAX_VALUE);
        }
*/
//
        //当线程池中线程数量大于corePoolSize（核心线程数量）或设置了allowCoreThreadTimeOut（是否允许空闲核心线程超时）时，
        // 线程会根据keepAliveTime的值进行活性检查，一旦超时便销毁线程。
        //(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()));
        /**
         * 1  newSingleThreadExecutor 默认核心数和最大数都是1  默认的队列,队列的容量是队列的整形的最大值
         */

        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();

        /**
         * 2 newFixedThreadPool 核心数和最大数同样相等  都是n
         *     public static ExecutorService newFixedThreadPool(int nThreads) {
         *         return new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         *     }
         */
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(100);

        /** 3 newCachedThreadPool 核心数是0 最大数是Integer.MAX_VALUE
         *     public static ExecutorService newCachedThreadPool() {
         *         return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
         *                                       60L, TimeUnit.SECONDS,
         *                                       new SynchronousQueue<Runnable>());
         *     }
         *
         *         public SynchronousQueue() {
         *         this(false);
         *     }
         */

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(100);

        /**
         * 拒绝策略
         *    - AbortPolicy 丢弃任务，抛运行时异常
         *    - CallerRunsPolicy 执行任务
         *    - DiscardPolicy 忽视，什么都不会发生
         *    - DiscardOldestPolicy 从队列中踢出最先进入队列（最后一个执行）的任务
         */
        for (int i = 0; i < MAX_NUM; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }
                }
            });
        }
//        while(Thread.activeCount()>1){
//            Thread.yield();
//        }
        //
        try {
            Thread.sleep(1000 * 10);
            System.out.println(Thread.activeCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
