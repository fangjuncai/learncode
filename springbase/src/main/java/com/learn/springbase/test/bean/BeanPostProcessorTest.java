package com.learn.springbase.test.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.security.PublicKey;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-19 23:27
 **/
@Component
public class BeanPostProcessorTest implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("postProcessBeforeInitialization before " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("postProcessAfterInitialization after " + beanName);
        return bean;
    }

}
