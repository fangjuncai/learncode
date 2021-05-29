package com.learn.springbase;

import com.learn.springbase.pojo.User;
import com.learn.springbase.test.CommonTest;
import com.learn.springbase.test.bean.ApplicationContextAwareTest;
import com.learn.springbase.test.bean.BeanFactoryTest;
import com.learn.springbase.test.resource.Main;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication()
@Slf4j
public class SpringbaseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbaseApplication.class, args);
        log.info("SpringbaseApplication welcome!");
        //CommonTest.testGetBean();

        BeanFactoryTest.test();
        if (ApplicationContextAwareTest.getObect("controller1") != null) {
            System.out.println(ApplicationContextAwareTest.getObect("controller1"));

        }
        context.getBean(Main.class).test();
        //context.close();

    }

}
