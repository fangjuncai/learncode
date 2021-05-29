package com.learn.springbase.test.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-19 19:28
 **/
@Component(value = "beanFactoryTest1")
public class BeanFactoryTest implements BeanFactoryAware, BeanNameAware {
    private static BeanFactory beanFactory;
    private static String beanName;

    @Override
    public void setBeanFactory(BeanFactory localBeanFactory) throws BeansException {
        beanFactory = localBeanFactory;
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
        System.out.println("bean name:" + name);
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public static void test() {
        if (null != beanFactory) {
            if (beanName != null) {
                System.out.println("beanName =" + beanName);
                System.out.println(beanFactory.getBean(beanName));
            }

        }

    }

    public static <T> T getBean(String beanName) {
        if (null != beanFactory) {
            return (T) beanFactory.getBean(beanName);
        }
        return null;
    }
}
