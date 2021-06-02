package com.learn.springbase.ioc.construct;

import com.learn.springbase.pojo.PayRecord;
import com.learn.springbase.pojo.PayReocordByConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: fangjc
 * @create: 2021-06-02 14:49
 **/
@Slf4j
public class IocConExample {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanset01.xml");
        PayReocordByConstruct payRecord = (PayReocordByConstruct) applicationContext.getBean("payReocordByConstruct");
        log.info("payRecord {}",payRecord);
    }
}
