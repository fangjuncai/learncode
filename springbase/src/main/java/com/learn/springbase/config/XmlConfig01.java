package com.learn.springbase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @description
 * @author: fangjc
 * @create: 2021-06-02 22:59
 **/
@Configuration
@ImportResource(locations = {"beanset01.xml"})
public class XmlConfig01 {
}
