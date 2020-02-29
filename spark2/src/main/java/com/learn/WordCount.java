package com.learn;

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
import java.util.Iterator;

public class WordCount {
    public static void main(String[] args) {
        if(args ==null ||args.length<1)
        {
            System.err.println("please input paths");
            System.exit(1);
        }
        String outfile =args[0];
        SparkConf sparkConf =new SparkConf().setMaster("local").setAppName("wordCount");
        JavaSparkContext sc =new JavaSparkContext(sparkConf);
        String inputFile="README.MD";
        JavaRDD<String> input =sc.textFile(inputFile);
        JavaRDD<String> lines =input.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
                //return null;
            }
        });

        //paris
        JavaPairRDD<String,Integer> paris = lines.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String,Integer>(s,1);
            }
        });
        //redues
        JavaPairRDD<String,Integer> counts=paris.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer+integer2;
            }
        });
        //output
        counts.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                System.out.println(stringIntegerTuple2);
            }
        });
        counts.saveAsTextFile(outfile);
        sc.stop();

    }
}
