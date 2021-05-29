package com.learn.springbase.test.resource;

import org.springframework.stereotype.Component;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-18 23:20
 **/
//@Component(value = "ps")
@Component
public class Person {
    public void say() {
        System.out.println("person say");
    }
}
