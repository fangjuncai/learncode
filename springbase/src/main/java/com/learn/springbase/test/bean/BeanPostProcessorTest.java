package com.learn.springbase.test.bean;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class BeanPostProcessorTest implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName != null && (beanName.equals("BeanPostProcessorTest")) || beanName.equals("ApplicationContextAwareTest"))
            log.info("postProcessBeforeInitialization before " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName != null && (beanName.equals("BeanPostProcessorTest")) || beanName.equals("ApplicationContextAwareTest"))
            log.info("postProcessAfterInitialization after " + beanName);
        return bean;
    }

}
