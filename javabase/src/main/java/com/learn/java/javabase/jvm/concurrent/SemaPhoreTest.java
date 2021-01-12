package com.learn.java.javabase.jvm.concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @description
 * @author: fangjc
 * @create: 2020-12-15 21:22
 **/
public class SemaPhoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for( int i  = 0 ; i < 10 ;i++)
        {
            final  int finalI = i;
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("access" + finalI);
                    try {
                        Thread.sleep(new Random().nextInt(5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("release" + finalI);
                    semaphore.release();
                }
            }).start();
        }
    }
}
