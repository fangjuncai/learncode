package com.learn.java.javabase.jvm.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-12 15:21
 **/
public class BlockingQueueTest {
    public static void main(String[] args) {
        test1();
    }
    private static  void  test1(){
        ArrayBlockingQueue<String> bdq = new ArrayBlockingQueue<String>(10);
        try {
            String bbb = "bbbb";
            bdq.put(bbb);
            bdq.offer("offer");
            bdq.put("aaa");
            bdq.offer("offer");
            bdq.put("aaa");
            bdq.offer("offer");
            bdq.put("aaa");
            bdq.offer("offer");
            bdq.put("aaa");
            bdq.offer("offer");
            //bdq.take();

            System.out.println(bdq);
            //bdq.take();
            bdq.remove(bbb);
            bdq.put("aaa1111");

            System.out.println(bdq);
            bdq.peek();
            bdq.poll();
            bdq.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LinkedBlockingDeque<String> ldq = new LinkedBlockingDeque<>();
        LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<>();
        try {
            ldq.put("aaa");
            ldq.offer("offer");
            ldq.take();
            ldq.peek();
            ldq.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            lbq.put("aaa");
            lbq.offer("offer");
            lbq.take();
            lbq.peek();
            lbq.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
