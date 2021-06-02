package com.learn.springbase.ioc.construct.autowire;

import com.learn.springbase.pojo.PayReocordByAuto;
import com.learn.springbase.pojo.PayReocordByConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: fangjc
 * @create: 2021-06-02 15:53
 **/
@Slf4j
public class IocAutowireExeample {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanset01.xml");
        PayReocordByAuto payRecord = (PayReocordByAuto) applicationContext.getBean("PayReocordByAuto");
        log.info("payRecord {}",payRecord);
    }
}
