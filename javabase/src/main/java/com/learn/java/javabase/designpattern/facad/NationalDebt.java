package com.learn.java.javabase.designpattern.facad;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NationalDebt {
    public void sell(){
        log.info("sell national debt");
    }
    public void buy(){
        log.info("buy national debt");
    }
}
