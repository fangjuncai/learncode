package com.learn.springbase.test.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-19 20:01
 * @Component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class="">)
 *
 * SpringBoot 在注入文件失败时，可能实例化类缺少@Componen
 **/

//@Component
public class ApplicationContextAwareTest implements ApplicationContextAware {
    private static ApplicationContext localContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("begin set localContext");
        localContext = applicationContext;

        System.out.println(localContext);
    }

    public static Object getObect(String name) {
        if (null != localContext) {
            System.out.println(localContext);
            if (null != localContext.getBean(name)) {
                return localContext.getBean(name);
            }
        }

        return null;
    }
}
