package com.learn.hadoop.spark.doc.analysis.chpater.rdd;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;

/**
 * map与flatmap的区别
 * map
 * [hello, spark, world]
 * [hello, java, world]
 * [hello, python, world]
 * <p>
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
 * <p>
 * 测试collect方法
 * [[hello, spark, world], [hello, java, world], [hello, python, world]]
 */
public class RddTest02 {

    public static void main(String[] args) {
        //Logger.getLogger("org.apache.spark").setLevel(Level.ERROR); //关掉idea控制台的日志

        //SparkConf sparkConf =new SparkConf().setMaster("local").setAppName("wordCount");
        //System.setProperty("hadoop.home.dir","D:\\work\\tools\\hadoop-3.0.0");
        SparkConf sparkConf = new SparkConf().setMaster("local[*]").setAppName("RddTest02");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("hello spark world ", "hello java world", "hello python world"));

        System.out.println("-----------------------------------------------");
        System.out.println("flat map:");
        JavaRDD<String> flatmap = rdd.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });

        flatmap.foreach(s -> System.out.println(s));
        System.out.println(flatmap.collect());

        System.out.println("-----------------------------------------------");
        System.out.println("map");
        JavaRDD<String> rddmap = rdd.map(new Function<String, String>() {
            @Override
            public String call(String s) throws Exception {
                //return Arrays.asList(s.split(" ")).toString();
                return s.toUpperCase();
            }
        });
        rddmap.foreach(s -> System.out.println(s));

        //返回的是一个List，但打印来就是一个数组
        System.out.println("-----------------------------------------------");
        System.out.println("test collect");
        System.out.println(rddmap.collect());

        /**
         * 测试保存
         */
        System.out.println("-----------------------------------------------");
        //输出搭配文件夹
        flatmap.saveAsTextFile("D:\\my\\code\\github\\learncode\\spark\\out\\wordflat\\"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd")));

        /**
         * 测试JavaPair 保存操作
         */
        JavaPairRDD<String, Integer> flatMapPair = flatmap.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s, 1);
            }
        });

        flatMapPair.saveAsTextFile("D:\\my\\code\\github\\learncode\\spark\\out\\flatMapPair\\"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd")));
        flatMapPair.saveAsHadoopFile("D:\\my\\code\\github\\learncode\\spark\\out\\hadoop", String.class, Integer.class, ConcreTextOutPutFormat.class);
        //SequenceFile保存
        //flatMapPair.saveAsHadoopFile("D:\\my\\code\\github\\learncode\\spark\\out\\hadoop", Text.class, IntWritable.class, ConcreTextOutPutFormat.class);

    }
}
