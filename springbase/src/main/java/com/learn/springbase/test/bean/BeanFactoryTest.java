package com.learn.springbase.test.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-19 19:28
 **/
@Component(value = "beanFactoryTest1")
@Slf4j
public class BeanFactoryTest implements BeanFactoryAware, BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean,BeanPostProcessor {
    private static BeanFactory beanFactory;
    private static String beanName;
    private int count = -1;

    @PostConstruct
    public void init() {
        log.info(beanName + " PostConstruct" + " " + count++);
    }

    @Override
    public void setBeanFactory(BeanFactory localBeanFactory) throws BeansException {
        beanFactory = localBeanFactory;
        log.info("BeanFactoryAware setBeanFactory name:" + beanFactory.getClass() + " " + count++);
    }

    @Override
    public void setBeanName(String name) {
        log.info("count ="+count);
        beanName = name;
        log.info("BeanNameAware setBeanName:" + name + " " + count++);
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public static void test() {
        if (null != beanFactory) {
            if (beanName != null) {
                log.info("beanName =" + beanName);
                log.info(beanFactory.getBean(beanName).toString());
            }

        }

    }

    public static <T> T getBean(String beanName) {
        if (null != beanFactory) {
            return (T) beanFactory.getBean(beanName);
        }
        return null;
    }

    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean destory" + " " + count++);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean afterPropertiesSet" + " " + count++);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("ApplicationContextAware setApplicationContext" + " " + count++);
    }


    //BeanPostProcessor没有注册成功，没有走到
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName != null && (beanName.equals("beanFactoryTest")) || beanName.equals("beanFactoryTest1"))
            log.info("BeanPostProcessor postProcessBeforeInitialization before " + beanName + " " + count++);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName != null && (beanName.equals("beanFactoryTest")) || beanName.equals("beanFactoryTest1"))
            log.info("BeanPostProcessor postProcessBeforeInitialization before " + beanName + " " + count++);
        return bean;
    }
}
