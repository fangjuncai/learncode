package com.learn.java.javabase.leecode.test;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-26 17:00
 **/
@Slf4j
public class PriorityQueueTest {
    public static void main(String[] args) {
        testPriorityQueueTest2();
    }
    private static void testPriorityQueueTest(){
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.add(111111);
        integers.add(11111);
        integers.add(1);
        integers.add(11);
        integers.add(111);
        integers.add(1111);
        log.info(integers.toString());
    }
    private static void testPriorityQueueTest2(){
        PriorityQueue<Integer> integers = new PriorityQueue<>((o1, o2) -> o2-o1);
        integers.add(111111);
        integers.add(11111);
        integers.add(1);
        integers.add(11);
        integers.add(111);
        integers.add(1111);
        log.info(integers.toString());
    }
}
