package com.learn.springbase.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import sun.misc.Contended;

import javax.annotation.PostConstruct;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-31 16:42
 **/
@Component
@Slf4j
public class WebService {
    @Autowired
    private ApplicationContext applicationContext;
    @PostConstruct
    public void init() {
        log.info("postcontruct init!");
        log.info("applicationContext ={}",applicationContext);
    }

    public WebService() {
        log.info("WebService Constructor!");
    }
}
