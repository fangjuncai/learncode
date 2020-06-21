package com.learn.hadoop.spark;

import com.learn.hadoop.spark.wordcount.BroadCastHolder;
import com.learn.hadoop.spark.wordcount.SparkContextHolder;
import com.learn.hadoop.spark.wordcount.WordRddFuntion;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.util.LongAccumulator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

@SpringBootApplication
@Slf4j
public class SparkApplication {


    public static void main(String[] args) {

        SpringApplication.run(SparkApplication.class, args);
        log.info("start spark app");

        JavaSparkContext jsc = SparkContextHolder.javaSparkContext;
        Broadcast<String> broadcast = BroadCastHolder.appNameCast;
        log.info(" jsc :{}",jsc.appName());
        log.info("jsc bro value: {}",BroadCastHolder.appNameCast.getValue());

        JavaRDD<String> input =jsc.parallelize(Arrays.asList("a j k l","a b c","d e f"," x y z "));

        input = input.map(new Function<String, String>() {
            @Override
            public String call(String v1) throws Exception {
                return v1.toUpperCase();
            }
        });


        input =input.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.trim().split(" ")).iterator();
            }
        });

        LongAccumulator longAccumulator = jsc.sc().longAccumulator();

        JavaRDD<String> words1 = input.mapPartitions(new WordRddFuntion(longAccumulator));
        words1.collect().forEach(item -> log.info(item));
        log.info("item number : {}",longAccumulator.value());

        jsc.stop();
    }

}
