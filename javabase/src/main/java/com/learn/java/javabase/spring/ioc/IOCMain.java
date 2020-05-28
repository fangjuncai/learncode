package com.learn.java.javabase.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-05-28 11:40
 **/

public class IOCMain {
    @Autowired
    PrintInterface printInterface;

    public void print(String name){
        printInterface.print(name);
    }
}
