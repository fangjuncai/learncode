package com.learn.springbase.test.resource;

import com.learn.springbase.SpringbaseApplication;
import com.learn.springbase.test.CommonTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-18 23:23
 **/

//@SpringBootApplication(scanBasePackages= "com.learn.springbase.test.resource")
@Slf4j
public class ResTestMain {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ResTestMain.class);
        ConfigurableApplicationContext context = springApplication.run(args);
        context.getBean(Main.class).test();
        context.close();
    }
}
