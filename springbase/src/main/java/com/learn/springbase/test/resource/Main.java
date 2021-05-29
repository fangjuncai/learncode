package com.learn.springbase.test.resource;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.PriorityQueue;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-18 23:20
 **/
@Component
public class Main {
    @Resource
    private Person ps;

    public void test() {
        ps.say();
    }
}
