package com.learn.hadoop.spark.wordcount;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@Data
@Slf4j
public class SparkContextHolder {

/*
    //'org.apache.spark.SparkConf' that could not be found. @Bean配置类
    @Autowired
    public SparkConf sparkConf;

    @Autowired
    public JavaSparkContext javaSparkContext;
*/
    public static SparkConf sparkConf;

    public static JavaSparkContext javaSparkContext;

    @Autowired
    public  void setSparkConf(SparkConf sparkConf){
        SparkContextHolder.sparkConf = sparkConf;
    }

    @Autowired
    public void setJavaSparkContext(JavaSparkContext javaSparkContext){
        SparkContextHolder.javaSparkContext = javaSparkContext;
        log.info("autowire javaSparkContext");
    }

}


