package com.learn.java.javabase.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description
 * @author: fangjc
 * @create: 2020-12-04 20:02
 **/
public class ReantLockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
