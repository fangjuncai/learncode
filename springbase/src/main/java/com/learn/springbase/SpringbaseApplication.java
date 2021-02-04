package com.learn.springbase;

import com.learn.springbase.pojo.User;
import com.learn.springbase.test.CommonTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication()
@Slf4j
public class SpringbaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbaseApplication.class, args);
        log.info("SpringbaseApplication welcome!");
        CommonTest.testGetBean();
    }

}
