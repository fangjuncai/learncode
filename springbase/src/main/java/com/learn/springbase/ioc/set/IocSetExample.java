package com.learn.springbase.ioc.set;

import com.learn.springbase.pojo.PayRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: fangjc
 * @create: 2021-05-31 15:25
 **/
@Slf4j
public class IocSetExample {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanset01.xml");
        PayRecord payRecord = (PayRecord) applicationContext.getBean("payRecord");
        log.info("payRecord {}",payRecord);
    }
}
