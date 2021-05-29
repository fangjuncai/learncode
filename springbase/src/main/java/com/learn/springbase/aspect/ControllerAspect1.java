package com.learn.springbase.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: fangjc
 * @create: 2021-05-28 20:52
 **/
@Aspect
@Slf4j
//不是可有可无的 不会被侦测到 并不会有这个bean https://blog.csdn.net/woshiyigeliangliang/article/details/81450443
@Component
public class ControllerAspect1 {
    @Pointcut(value = "execution( * com.learn.springbase.control.Controller.*(..))")
    public  void pointcut1(){
        log.info("pointcut1");
    }
    @Before(value = "pointcut1()")
    public void beforePointcut1(){
        log.info("beforePointcut1");
    }
}
