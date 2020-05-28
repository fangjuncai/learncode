package com.learn.hadoop.spark.wordcount;

import lombok.extern.slf4j.Slf4j;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.json4s.JsonUtil;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@Slf4j
public class Main01 {
    public static void main(String[] args) {
        //SparkConf sparkconf = new SparkConf().setAppName("main01").setMaster("local[*]");
        SparkConf sparkconf = new SparkConf().setAppName("main01");
        // System memory 186646528 must be at least 471859200. Please increase heap size using the --driver-memory option or spark.driver.memory in Spark configuration.
        // 471859200 (450.0MB)
        //val systemMemory = conf.getLong("spark.testing.memory", Runtime.getRuntime.maxMemory)。
        //https://www.cnblogs.com/AlanWilliamWalker/p/11680933.html
        sparkconf.set("spark.testing.memory", "2147480000");//大于512M
        JavaSparkContext jsc = new JavaSparkContext(sparkconf);

        JavaRDD<String> input =jsc.parallelize(Arrays.asList("a j k l","a b c","d e f"," x y z "));

        input = input.map(new Function<String, String>() {
            @Override
            public String call(String v1) throws Exception {
                return v1.toUpperCase();
            }
        });
        input =input.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String v1) throws Exception {
                return  v1.contains("a") || v1.contains("A");
            }
        });

        input =input.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });
        List<String> out =input.collect();
        

        JavaRDD<String> input2 = jsc.parallelize(Arrays.asList("A","set"));

        JavaPairRDD<String,Integer> inputPair= input.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s,1);
            }
        });
        JavaPairRDD<String,Integer> inputPair2= input2.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s,1);
            }
        });
        //out.forEach(System.out::println);
        //TODO 采用的是spark下的conf log4j.properity  是可以打印的
        out.forEach(item -> log.info(item));
/*        inputPair.join(inputPair2).foreach(new VoidFunction<Tuple2<String, Tuple2<Integer, Integer>>>() {
            @Override
            public void call(Tuple2<String, Tuple2<Integer, Integer>> stringTuple2Tuple2) throws Exception {
                System.out.println(stringTuple2Tuple2.toString());
            }
        });
        inputPair.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                System.out.println(stringIntegerTuple2.toString());
            }
        });*/
        //out.forEach(System.out::println);
    }
}
