package com.learn.java.javabase.examination;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description
 * @author: fangjc
 * @create: 2020-11-17 21:13
 **/
public class ABCTest {
    /*
 问题：实现一个多线程类，并用该线程类实例化3个线程A,B,C；A线程打印字符A,B线程打印字符B，C线程打印字符C；
 启动这3个线程，要求启动线程的顺序为C线程->B线程->A线程，并且最后输出内容为：
A
B
C
不能用sleep函数，注意考虑线程安全问题。编程语言不限
*/
    private static volatile int num = 1;
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();
    private static ReentrantLock lock2 = new ReentrantLock();

    private static Condition D= lock2.newCondition();
    static class ThreadA extends Thread {
        public void run() {
            lock.lock();
            lock2.lock();
            while (num != 1) {
                try {
                    A.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A");
            num = 2;
            B.signal();
            lock.unlock();
        }

    }

    static class ThreadB extends Thread {

        public void run() {
            lock.lock();
            try {
                while (num != 2) {
                    B.await();
                }
                System.out.println("B");
                num = 3;
                C.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.unlock();
        }

    }

    static class ThreadC extends Thread {
        public void run() {
            lock.lock();
            try {
                while (num != 3) {
                    C.await();
                }
                A.signal();//唤起A
                num = 1;
                //C.await();//等待
                System.out.println("C");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();

        }

    }

    public static void main(String[] args) {
        new ThreadC().start();
        new ThreadB().start();
        new ThreadA().start();
    }

}
