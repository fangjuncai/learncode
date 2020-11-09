package com.learn.hadoop.spark.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * @program: spark
 * @description
 * @author: fangjc
 * @create: 2020-06-22 20:38
 **/
@Component
@Slf4j
@Configuration
public class AppConfig {
    public static String appTestValue;

    @PostConstruct
    public void init(){
        log.info("AppConfig init");
    }
    @Value("${app.value.autowired.test}")
    public void setAppTestValue(String appTestValue)
    {
        AppConfig.appTestValue = appTestValue;
    }
}
