package com.learn.java.javabase.jvm.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description
 * @author: fangjc
 * @create: 2020-12-01 14:46
 **/
public class AtomicClassTest {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(10,1);
        AtomicReference<String> atomicReference = new AtomicReference<>();
        System.out.println(atomicReference.getAndSet("t1"));
        System.out.println(atomicStampedReference.getReference() + " " + atomicStampedReference.getStamp());
    }
}
