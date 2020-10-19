package com.learn.java.javabase.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-08-09 20:09
 **/
@Slf4j
public class LoginTest01 {
    public static void main(String[] args) {
        //Jedis redisClient = new Jedis("192.168.56.130",6379);
        Jedis redisClient = new Jedis("119.45.207.171",6379);
        redisClient.set("tk1","v1");
        log.info(" tk1 value {}",redisClient.get("tk1"));
    }
}
