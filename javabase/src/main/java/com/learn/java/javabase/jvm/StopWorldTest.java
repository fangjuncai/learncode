package com.learn.java.javabase.jvm;

import java.util.HashMap;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-10 15:54
 *  * 启动参数：-Xmx512m -Xms512m -XX:+UseSerialGC -XX:+PrintGCDetails -Xmn1m
 *  *
 *  * -XX:+UseSerialGC:新生代和老年代都用单线程的串行回收器。适合单核并发能力差得处理器。
 *  * -XX:+UseParNewGC:新生代用并行的ParNew回收期，老年代都用单线程的串行回收器。适合多核，并发能力强的处理器。
 *  * -XX:+UseParallelGC:新生代使用ParallelGC回收器，老年代使用串行回收器。
 *    -XX:+UseParallelOldGC:新生代使用ParallelGC回收器，老年代使用ParallelOldGC回收器。
 *  * 1）--
 *  * -XX:+UseConclMarkSweepGC:老年代使用CMS回收器。
 *  *
 *

 * 链接：https://www.jianshu.com/p/d686e108d15f
 **/
public class StopWorldTest {

    public static class MyThread extends Thread{
        HashMap<Long,byte[]> map=new HashMap<Long, byte[]>();

        public MyThread(String name) {
            super(name);

        }

        @Override
        public void run() {
            try {
                while (true){
                    if(map.size()*512/1024/1024>=450){
                        System.out.println("============准备清理==========:"+map.size());//大于450M时，清理内存。
                        map.clear();
                        System.out.println("clean map");
                    }
                    for(int i=0;i<100;i++){
                        map.put(System.nanoTime(),new byte[512]);//消耗内存。
                    }
                    Thread.sleep(1);
                }
            }catch (Exception e){
                System.out.println("failed");
                e.printStackTrace();
            }
        }
    }
    public static class PrintThread extends Thread {

        public PrintThread(String name) {
            super(name);

        }

        public static final long starttime = System.currentTimeMillis();

        @Override
        public void run() {
            try {
                while (true) {
                    long t = System.currentTimeMillis() - starttime;
                    System.out.println("time:" + t);
                    Thread.sleep(100);
                }
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        MyThread t=new MyThread("test");
        PrintThread p=new PrintThread("print");
        t.start();
        p.start();
    }
}