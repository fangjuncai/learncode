package com.learn.java.javabase.designpattern.facad;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Found {
    Socket01 socket01 = new Socket01();
    Socket02 socket02 = new Socket02();
    Socket03 socket03 = new Socket03();
    NationalDebt nationalDebt = new NationalDebt();

    public void methodA(){
        log.info("found methodA");
        socket01.sell();
        socket02.buy();
    }
    public void methodB(){
        log.info("found methodB");
        socket03.buy();
        nationalDebt.buy();
    }
}
