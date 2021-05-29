package com.learn.springbase.test.bean;

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
@Component(value = "beanNameAwareTest1")
public class BeanNameAwareTest implements BeanNameAware, InitializingBean, DisposableBean {
    private String name;
    @PostConstruct
    public void init(){
        System.out.println(this.name + " " + "PostConstruct");
    }
    @Override
    public void setBeanName(String name) {
        this.name = name;
        System.out.println(this.name);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet " + this.name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("desotry " + name);
    }
}
