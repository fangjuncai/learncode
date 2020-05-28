package com.learn.java.javabase;

import com.learn.java.javabase.spring.ioc.IOCMain;
import com.learn.java.javabase.spring.ioc.PrintInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = {"com.learn.java.javabase.spring.ioc"})
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
@Component
public class JavabaseApplication {

    @Qualifier("PrintImpl01")
    @Autowired
    PrintInterface printInterface;
    public static JavabaseApplication javabaseApplication;
    @PostConstruct
    public void init(){
        javabaseApplication =this;
    }
    public static void main(String[] args) {
        SpringApplication.run(JavabaseApplication.class, args);
        javabaseApplication.printInterface.print("name");
    }
}
