package com.learn.java.javabase.spring.ioc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-05-28 11:41
 **/
@Slf4j
@Service
public class PrintImpl02 implements PrintInterface{
    @Override
    public void print(String name) {
        log.info("PrintImpl02 {}",name);
    }
}
