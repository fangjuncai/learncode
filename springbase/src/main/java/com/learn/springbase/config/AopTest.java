package com.learn.springbase.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-06 17:02
 **/
@Component
@Aspect
@Slf4j
public class AopTest {
    @Pointcut("execution(* com.learn.springbase.control.Controller.healCheck())")
    public void testAop1(){

    }
    @Pointcut("execution(* com.learn.springbase.control.Controller.*(..))")
    public void testAop2(){

    }
    @Before(value = "testAop2()")
    public void testBeforeAop2(){
        log.info("---before test aop2");
    }
    @Before(value = "testAop1()")
    public void testBeforeAop1(){
        log.info("---before test aop1");
    }
    @After(value = "testAop1()")
    public void testAfter(){
        log.info("---after test aop1");
    }

    @AfterThrowing(value = "testAop1()")
    public void testAfterThrowing(){
        log.info("--after test  aop1");
    }
    @AfterReturning(value = "testAop1()")
    public void testAfterReturning(){
        log.info("--after return test  aop1");
    }
/*    @Around(value = "testAop1()")
    public Object testAfterAround(){
        log.info("---around test  exe");
        return "around";
    }*/
}
