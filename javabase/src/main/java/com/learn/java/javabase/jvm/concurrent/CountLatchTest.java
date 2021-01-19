package com.learn.java.javabase.jvm.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-14 20:15
 **/
public class CountLatchTest {
    final static CountDownLatch countDownLatch = new CountDownLatch(4);
    public static void main(String[] args) {
        System.out.println("main start");
        test();
        try {
            countDownLatch.await();
            //countDownLatch.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //test();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
    private static void test(){

        for(int i=0;i<4;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                    System.out.println("end");
                }
            }).start();
        }

        for(int i=0;i<4;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                    System.out.println("end");
                }
            }).start();
        }
    }
}
