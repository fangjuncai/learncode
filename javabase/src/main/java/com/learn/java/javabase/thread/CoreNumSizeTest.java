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
        LinkedBlockingDeque queue =new LinkedBlockingDeque();
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        //ArrayBlockingQueue queue= new ArrayBlockingQueue<>(5);
        //ExecutorService executorService = new ThreadPoolExecutor(2, 4, 30L, TimeUnit.SECONDS, queue);

        //ExecutorService executorService = Executors.newFixedThreadPool(3);

        //ExecutorService executorService = Executors.newCachedThreadPool();
        //ExecutorService executorService = Executors.newScheduledThreadPool(10);
        int i =0;
        for(i = 0; i < Integer.MAX_VALUE ;i++)
        {
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
                    int count=0;
                    boolean flag = true;

                    while (flag){
                        try {
                            Thread.sleep(1000);
                            count++;
                            if(count == 30)
                            {
                                flag = false;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread()+" " + finnl1);
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
