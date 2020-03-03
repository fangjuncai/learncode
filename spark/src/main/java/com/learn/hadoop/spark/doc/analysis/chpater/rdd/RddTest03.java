package com.learn.hadoop.spark.doc.analysis.chpater.rdd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 */
public class RddTest03 {
    public static void main(String[] args) {
        SparkConf conf =new SparkConf().setMaster("local").setAppName("RddTest03");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> rdd =sc.parallelize(Arrays.asList("welcome","welcome hell world","welcome python world","welcome java world"));
        JavaRDD<String> words = rdd.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });


        //输出所有的word
        System.out.println("console all word");
        words.foreach(s -> System.out.println(s));

        JavaPairRDD<String,Integer> wordPairs = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s,1);
            }
        });
        //输出所有的对pairRDD
        System.out.println("console all pair");
        //wordPairs.foreach(stringIntegerTuple2 -> System.out.println(stringIntegerTuple2));
        wordPairs.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                System.out.println(stringIntegerTuple2);
            }
        });
        //归纳redues
        JavaPairRDD<String,Integer> wordredues = wordPairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer+integer2;
            }
        });
        //输出字符统计
        System.out.println("console all");
        wordredues.foreach(stringIntegerTuple2 -> System.out.println(stringIntegerTuple2));
        wordredues.sortByKey(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        wordredues.foreach(stringIntegerTuple2 -> System.out.println(stringIntegerTuple2));

        //测试自定义排序,暂未实现
        //System.out.println("test define sort:");
        /*wordredues.sortByKey(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });*/


        wordredues.foreach(stringIntegerTuple2 -> System.out.println(stringIntegerTuple2));

        //测试默认排序,默认是ascending(上升)true，如果sortByKey参数是false则是降序
        System.out.println("test sort:");
        wordredues.sortByKey(true).foreach(stringIntegerTuple2 -> System.out.println(stringIntegerTuple2));

    }
}
class IntegerComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return String.valueOf(a).compareTo(String.valueOf(b));
    }
}