package com.learn.hadoop.spark.wordcount;

import lombok.extern.slf4j.Slf4j;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.util.LongAccumulator;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@Slf4j
public class Main01 {
    public static void main(String[] args) {
/*        //SparkConf sparkconf = new SparkConf().setAppName("main01").setMaster("local[*]");//TODO local文件读写都在本地
        //org.apache.hadoop.mapred.FileAlreadyExistsException: Output directory
        SparkConf sparkconf = new SparkConf().setAppName("main01").set("spark.hadoop.validateOutputSpecs", "false");
        // System memory 186646528 must be at least 471859200. Please increase heap size using the --driver-memory option or spark.driver.memory in Spark configuration.
        // 471859200 (450.0MB)
        //val systemMemory = conf.getLong("spark.testing.memory", Runtime.getRuntime.maxMemory)。
        //https://www.cnblogs.com/AlanWilliamWalker/p/11680933.html
        sparkconf.set("spark.testing.memory", "2147480000");//大于512M*/
        JavaSparkContext jsc = SparkContextHolder.javaSparkContext;

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
        //读
        JavaRDD<String> words  = jsc.textFile("/user/root/word.txt",3);
        //设置广播变量
        Broadcast<List<String>>  broadcast = jsc.broadcast(out);
        //累加器
        // Accumulator must be registered before send to executor  创建并注册累加器
        LongAccumulator longAccumulator = jsc.sc().longAccumulator();


        JavaRDD<String> words1 = words.mapPartitions(new FlatMapFunction<Iterator<String>, String>() {

            @Override
            public Iterator<String> call(Iterator<String> stringIterator) throws Exception {
                ArrayList<String>  list = new ArrayList<>();
                while(stringIterator.hasNext()){
                    String  item  = stringIterator.next();
                    StringBuilder stringBuilder = new StringBuilder();
                    //将广播变量的值添加到列表中
                    stringBuilder.append(item).append("--").append(broadcast.getValue().toString());
                    list.add(stringBuilder.toString());
                    longAccumulator.add(1);

                }
                return list.iterator();
            }
        });
        //写
        words1.saveAsTextFile("/user/root/outword");

        //collect打印
        JavaRDD<String> hdfsResult  = jsc.textFile("/user/root/outword/part*");
        hdfsResult.collect().forEach(item -> log.info(" hdfs result item {}",item));
        log.info("item number : {}",longAccumulator.value());


        jsc.stop();
    }
}
