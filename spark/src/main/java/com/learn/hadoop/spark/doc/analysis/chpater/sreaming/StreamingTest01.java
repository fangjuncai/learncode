package com.learn.hadoop.spark.doc.analysis.chpater.sreaming;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StreamingTest01 {
    public static void main(String[] args) {
        Logger.getLogger("org.apache.spark").setLevel(Level.ERROR); //关掉idea控制台的日志
        SparkConf conf = new SparkConf().setAppName("StreamingTest01").setMaster("local[*]");
        JavaStreamingContext jsc = new JavaStreamingContext(conf, Durations.seconds(5));

        //JavaReceiverInputDStream<String> lines =jsc.socketTextStream("192.168.0.108",9999); win10 Linux子系统，本地地址
        JavaReceiverInputDStream<String> lines = jsc.socketTextStream("localhost", 9999);
        JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });

        /* mapToPair是每次都会放到executor中计算一次，mapPartitionsToPair把整个分区的数据计算一次，需要考虑OOM
        JavaPairDStream<String, Integer> wordpairs = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s, 1);
            }
        });
        */

        JavaPairDStream<String, Integer> wordpairs =words.mapPartitionsToPair(new PairFlatMapFunction<Iterator<String>, String, Integer>() {
            @Override
            public Iterator<Tuple2<String, Integer>> call(Iterator<String> stringIterator) throws Exception {
                List<Tuple2<String,Integer>> list = new ArrayList<Tuple2<String, Integer>>();
                while(stringIterator.hasNext()){
                    String s =stringIterator.next();
                    list.add(new Tuple2<>(s,1));
                }
                return list.iterator();
            }
        });

        JavaPairDStream<String, Integer> keycounts = wordpairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });

        keycounts.print();
        jsc.start();
        try {
            jsc.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
