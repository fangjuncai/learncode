package com.learn.java.javabase.designpattern.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestTemplate {
    public static void main(String[] args) {
        TestPaper testPaper1 =new TestPaperA();
        TestPaper testPaper2 =new TestPaperB();

        log.info("学生A的试卷");
        testPaper1.TestQuestion1();
        testPaper1.TestQuestion2();
        testPaper1.TestQuestion3();

        log.info("学生b的试卷");
        testPaper2.TestQuestion1();
        testPaper2.TestQuestion2();
        testPaper2.TestQuestion3();
    }
}
