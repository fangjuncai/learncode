package com.learn.springbase.test.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-19 19:07
 **/
//@Component(value = "beanNameAwareTest1")
@Slf4j
public class BeanNameAwareTest implements BeanNameAware, InitializingBean, DisposableBean {
    private String name;
    @PostConstruct
    public void init(){
        System.out.println(this.name + " " + "PostConstruct");
    }
    @Override
    public void setBeanName(String name) {
        this.name = name;
        log.info(this.name);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet " + this.name);
    }

    @Override
    public void destroy() throws Exception {
        log.info("desotry " + name);
    }
}
