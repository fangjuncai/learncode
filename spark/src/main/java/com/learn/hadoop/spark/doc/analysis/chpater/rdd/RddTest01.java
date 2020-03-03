package com.learn.hadoop.spark.doc.analysis.chpater.rdd;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;

import java.util.Arrays;

public class RddTest01 {
    public static void main(String[] args) {
        //SparkConf sparkConf =new SparkConf().setMaster("local").setAppName("wordCount");
        //System.setProperty("hadoop.home.dir","D:\\work\\tools\\hadoop-3.0.0");
        SparkConf sparkConf =new SparkConf().setMaster("local").setAppName("RddTest01");
        JavaSparkContext sc =new JavaSparkContext(sparkConf);
        JavaRDD<Integer> rdd =sc.parallelize(Arrays.asList(1,2,3,4));
        JavaRDD<Integer> result =rdd.map(new Function<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) throws Exception {
                return integer*integer;
            }
        });
        System.out.println(rdd.toString());
        //System.out.println(StringUtils.join(result.collect(),","));

        rdd.foreach(new VoidFunction<Integer>() {
            @Override
            public void call(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });

    }
}
