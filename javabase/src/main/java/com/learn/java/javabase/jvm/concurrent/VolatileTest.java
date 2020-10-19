package com.learn.java.javabase.jvm.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
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
    private static void increase(){
        counter++;
    }
    private static final int MAX_NUM=20;

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(MAX_NUM,MAX_NUM, 0,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(MAX_NUM),new ThreadPoolExecutor.DiscardPolicy());

        for(int i =0;i<MAX_NUM;i++)
        {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for(int j =0;j<1000;j++){
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
            Thread.sleep(1000*10);
            System.out.println(Thread.activeCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
