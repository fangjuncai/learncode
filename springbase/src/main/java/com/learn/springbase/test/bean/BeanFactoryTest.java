package com.learn.springbase.test.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-19 19:28
 **/
@Component(value = "beanFactoryTest1")
@Slf4j
public class BeanFactoryTest implements BeanFactoryAware, BeanNameAware, ApplicationContextAware ,InitializingBean, DisposableBean {
    private static BeanFactory beanFactory;
    private static String beanName;

    @Override
    public void setBeanFactory(BeanFactory localBeanFactory) throws BeansException {
        beanFactory = localBeanFactory;
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
        log.info("bean name:" + name);
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

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
