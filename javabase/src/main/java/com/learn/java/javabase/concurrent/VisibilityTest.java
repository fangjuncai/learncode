package com.learn.java.javabase.concurrent;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-07-26 18:22
 **/
public class VisibilityTest extends Thread{
    private boolean stop;

    public void run() {
        int i = 0;
        while (!stop) {
/*            try {
                //Sleep结果不一样 stop值检查了
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

    public static void main(String[] args) throws Exception {
        VisibilityTest v = new VisibilityTest();
        v.start();
        System.out.println(v.getStop());
        Thread.sleep(5000);
        v.stopIt();
        Thread.sleep(2000);
        System.out.println("finish main");
        System.out.println(v.getStop());
    }
}
