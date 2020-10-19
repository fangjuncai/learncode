package com.learn.java.javabase.jvm.concurrent;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-07-24 22:19
 **/
public class VolatioleTest2 extends Thread{
    public  boolean stop = false;
    public static void main(String[] args) {
        VolatioleTest2 volatioleTest2 = new VolatioleTest2();
        System.out.println( volatioleTest2.getStop());
        volatioleTest2.start();
        try {
            Thread.sleep(1000*5);
            //volatioleTest2.stop = true;
            volatioleTest2.stopIt();
            System.out.println( volatioleTest2.getStop());
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        int i = 0;
        while (!stop) {
/*            try {
                //防止计算的太快
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            i++;
        }
        System.out.println("finish loop,i=" + i);
    }
    public void stopIt() {
        stop = true;
    }

    public boolean getStop() {
        return stop;
    }



}
