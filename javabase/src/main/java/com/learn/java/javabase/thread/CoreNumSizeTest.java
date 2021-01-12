package com.learn.java.javabase.thread;

import java.time.LocalDateTime;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description
 * @author: fangjc
 * @create: 2020-11-18 18:04
 **/
public class CoreNumSizeTest {
    public static void main(String[] args) {
        LinkedBlockingDeque queue = new LinkedBlockingDeque();
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        //ArrayBlockingQueue queue= new ArrayBlockingQueue<>(5);
        executorService = new ThreadPoolExecutor(2, 4, 30L, TimeUnit.SECONDS, queue);

        executorService = Executors.newSingleThreadExecutor();
        //nThreads, nThreads  0 LinkedBlockingQueue
        executorService = Executors.newFixedThreadPool(3);
        //0, Integer.MAX_VALUE, 60s SynchronousQueue
        executorService = Executors.newCachedThreadPool();
        //corePoolSize, Integer.MAX_VALUE 0 DelayedWorkQueue
        //executorService = Executors.newScheduledThreadPool(10);
/*        ScheduledExecutorService  scheduledExecutorService = Executors.newScheduledThreadPool(10);
        System.out.println(LocalDateTime.now());
        //延迟执行一次
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(LocalDateTime.now());
                System.out.println("test schedule");
            }
        }, 3,TimeUnit.SECONDS);
        //延迟周期运行
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(LocalDateTime.now());
                System.out.println("test schedule delay");
            }
        },3,3,TimeUnit.SECONDS);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //scheduledExecutorService.shutdown();


        int i = 0;
        for (i = 0; i < Integer.MAX_VALUE; i++) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(queue.size());
            int finnl1 = i;

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    int count = 0;
                    boolean flag = true;

                    while (flag) {
                        try {
                            Thread.sleep(1000);
                            count++;
                            //控制线程执行时间
                            if (count == 30) {
                                flag = false;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread() + " " + finnl1);
                    }


                }
            });

        }
/*        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        System.out.println(LocalDateTime.now());
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
                System.out.println(LocalDateTime.now());
            }
        }, 3, TimeUnit.SECONDS);
        System.out.println(LocalDateTime.now());*/


    }
}
