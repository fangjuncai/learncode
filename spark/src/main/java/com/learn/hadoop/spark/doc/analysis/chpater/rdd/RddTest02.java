package com.learn.hadoop.spark.doc.analysis.chpater.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;

import java.util.Arrays;
import java.util.Iterator;

/**
 * map与flatmap的区别
 * map
 * [hello, spark, world]
 * [hello, java, world]
 * [hello, python, world]
 *
 * flatmap
 * hello
 * spark
 * world
 * hello
 * java
 * world
 * hello
 * python
 * world
 *
 * 测试collect方法
 * [[hello, spark, world], [hello, java, world], [hello, python, world]]
 */
public class RddTest02 {
    public static void main(String[] args) {
        //SparkConf sparkConf =new SparkConf().setMaster("local").setAppName("wordCount");
        //System.setProperty("hadoop.home.dir","D:\\work\\tools\\hadoop-3.0.0");
        SparkConf sparkConf =new SparkConf().setMaster("local").setAppName("RddTest01");
        JavaSparkContext sc =new JavaSparkContext(sparkConf);
        JavaRDD<String> rdd =sc.parallelize(Arrays.asList("hello spark world ","hello java world","hello python world"));
        
        JavaRDD<String> flatmap =rdd.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });
        System.out.println("flat map:");
        flatmap.foreach(s -> System.out.println(s));
        System.out.println("map");
        JavaRDD<String> rddmap =rdd.map(new Function<String, String>() {
            @Override
            public String call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).toString();
            }
        });
        rddmap.foreach(s -> System.out.println(s));

        //返回的是一个List，但打印来就是一个数组
        System.out.println("test collect");
        System.out.println(rddmap.collect());

    }
}
