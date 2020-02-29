package com.learn.java.javabase.designpattern.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestPaperB extends TestPaper{
    @Override
    public void TestQuestion1() {
        super.TestQuestion1();
        answer1();
    }

    @Override
    public void TestQuestion2() {
        super.TestQuestion2();
        answer2();
    }

    @Override
    public void TestQuestion3() {
        super.TestQuestion3();
        answer3();
    }

    @Override
    protected void answer1() {
        log.info("b");
    }

    @Override
    protected void answer2() {
        log.info("b");
    }

    @Override
    protected void answer3() {
        log.info("b");
    }
}
