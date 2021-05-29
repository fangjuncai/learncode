package com.learn.springbase.test;

import com.learn.springbase.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @description
 * @author: fangjc
 * @create: 2021-02-04 16:25
 **/
@Slf4j
public class CommonTest {
    public static void main(String[] args) {
     //testGetBean();
        testXml();
    }

    public static void  testXml() {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        User user = (User) xmlBeanFactory.getBean("User");
        log.info("user = {}",user);

    }
    public static void testGetBean(){
        // 1.初始化ioc容器(装对象的容器)
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        log.info("context ={}",context);
        //2.从容器中获得创建好的对象
        //User user = (User) context.getBean("User");
        //如果没有指定id name
        //User user = (User) context.getBean("com.learn.springbase.pojo.User");
        //User user = (User) context.getBean(User.class);
        User user= (User) context.getBean("user");
        log.info(user.toString());
    }
}
