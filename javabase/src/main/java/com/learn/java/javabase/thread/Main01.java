package com.learn.java.javabase.thread;

import sun.java2d.loops.GraphicsPrimitive;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-06-04 19:35
 **/
public class Main01 {
    public static void main(String[] args) {
        test();
    }

    public static int testFinally() {
        int i;
        try {
            i = 1;
           // throw  new Exception();
            return i;
        } catch (Exception e) {
            i = 2;
            return i;
        } finally {
            i = 3;
            return i;
        }
    }
    private  static void test(){
        AtomicLong atomicLong = new AtomicLong();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

        LinkedBlockingDeque blockingDeque  = new LinkedBlockingDeque();
        ArrayBlockingQueue<String> blockingDeque1 = new ArrayBlockingQueue<String>(16);
        blockingDeque.add("1");
        blockingDeque1.add("1");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.get(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child begin park"
                );
                LockSupport.park();
                System.out.println("child unpark");
            }
        });
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end 1");
        //LockSupport.unpark(t1);

        System.out.println("end 2");
    }
}
