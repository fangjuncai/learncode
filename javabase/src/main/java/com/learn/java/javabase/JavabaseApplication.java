package com.learn.java.javabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = {"com.learn.java.javabase"})
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})

public class JavabaseApplication {


    public static JavabaseApplication javabaseApplication;
    @PostConstruct
    public void init(){
        javabaseApplication =this;
    }
    public static void main(String[] args) {
        SpringApplication.run(JavabaseApplication.class, args);

    }
}
