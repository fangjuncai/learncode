package com.learn.java.javabase.jvm;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-12 18:48
 **/
public class VolatileTest01 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger= new AtomicInteger(0);
        atomicInteger.getAndIncrement();
        RedisTemplate redisTemplate= new RedisTemplate();
        String ob = new String("ob");
        redisTemplate.opsForValue().setIfAbsent(ob,"1");
        redisTemplate.delete(ob);
    }
}
