package com.learn.hadoop.spark.wordcount;

import com.learn.hadoop.spark.config.AppConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @program: spark
 * @description
 * @author: fangjc
 * @create: 2020-06-12 11:21
 **/
@Component
@Data
@Slf4j
public class BroadCastHolder implements Serializable {
    public static Broadcast<String> appNameCast;

    @Autowired
    public void setAppNameCast(JavaSparkContext jsc){
        appNameCast = jsc.broadcast(AppConfig.appTestValue);
    }


}
