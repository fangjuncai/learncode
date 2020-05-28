package com.learn.java.javabase.spring.ioc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Qualifier("PrintImpl01")
public class PrintImpl01 implements PrintInterface{
    @Override
    public void print(String name) {
        log.info("PrintImpl01 {}",name);
    }
}
