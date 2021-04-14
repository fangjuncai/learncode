package com.learn.java.javabase.concurrent;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description
 * @author: fangjc
 * @create: 2020-11-26 22:53
 **/
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap();
        String v1 = concurrentHashMap.put("k1", "v1");
        System.out.println(v1);
        String v2 = concurrentHashMap.put("k1", "v2");
        System.out.println(v2);
        String v3 = concurrentHashMap.put("k1", "v3");
        System.out.println(v3);
        //concurrentHashMap.put(null,"null");
        System.out.println(concurrentHashMap.toString());
        System.out.println(concurrentHashMap.get("k1"));
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null, "v1");
        hashMap.put("k1", "v1");
        hashMap.get("t1");
        System.out.println(hashMap.size());
        System.out.println(hashMap.toString());

    }
}
