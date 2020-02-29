package com.learn.java.javabase.designpattern.template;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class TestPaper {
    public void TestQuestion1(){
        log.info("明朝的开国皇帝是: a.朱元璋 b.朱棣 c.努尔哈赤 d.赵匡胤");
    }
    public void TestQuestion2(){
        log.info("中华人民共和国的建立时间是: a.1959年10月1日 b.1949年10月1日 c.1949年9月1日 d.1949年5月4日 ");
    }
    public void TestQuestion3(){
        log.info("东汉的开国皇帝是: a.刘邦 b.刘秀 c.刘渊 d.刘彻");
    }
    protected abstract void answer1();
    protected abstract void answer2();
    protected abstract void answer3();
}