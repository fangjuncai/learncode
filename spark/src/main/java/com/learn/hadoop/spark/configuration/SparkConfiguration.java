package com.learn.hadoop.spark.configuration;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @program: spark
 * @description
 * @author: fangjc
 * @create: 2020-06-12 16:27
 **/
@Configuration
public class SparkConfiguration {
    @Bean
    SparkConf getSparkConf(){
        return new SparkConf();
    }
    @Bean
    JavaSparkContext getJavaSparkContext(SparkConf sparkConf){
        sparkConf.setAppName("app name1").setMaster("local[*]");
        //sparkConf.setAppName("main01").set("spark.hadoop.validateOutputSpecs", "false");
        return new JavaSparkContext(sparkConf);
    }
}
