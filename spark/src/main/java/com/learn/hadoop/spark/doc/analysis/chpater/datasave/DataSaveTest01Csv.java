package com.learn.hadoop.spark.doc.analysis.chpater.datasave;

import com.opencsv.CSVReader;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import scala.Tuple2;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 测试spark 数据保存和读取
 * 读取csv文件
 */
public class DataSaveTest01Csv {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("DataSaveTest01");
        JavaSparkContext sc  = new JavaSparkContext(conf);
        //wholeTextFiles输出整个目录的文件,每个文件就是一个记录，不是按照行读取
        String inputfile = "D:\\my\\code\\github\\learncode\\spark\\src\\main\\resources\\res\\sparksave\\";
        //读取文件或者目录下的数据，以文件为一个单独的记录读取
        JavaPairRDD<String,String> csvData =sc.wholeTextFiles(inputfile);
        //打印读取的文件与文件内容键值对
        System.out.println(csvData.collect());
        //JavaRDD<String []>keyedRdd =csvData.flatMap(new ParseLine());
        //只输出文件中的内容，不作其他的处理
        JavaRDD<String []>keyedRdd =csvData.flatMap(new FlatMapFunction<Tuple2<String, String>, String[]>() {
            @Override
            public Iterator<String[]> call(Tuple2<String, String> stringStringTuple2) throws Exception {
                CSVReader reader = new CSVReader(new StringReader(stringStringTuple2._2));
                return reader.readAll().iterator();
            }
        });
        //keyedRdd.foreach(x -> System.out.println(x);输出的是对象
        keyedRdd.foreach(x -> System.out.println(Arrays.asList(x).toString()));
    }

}
/*
目录下两个文件，相同的内容
    1,jack,male,29
    2,linda,female,29

输出
    [(file:/D:/my/code/github/learncode/spark/src/main/resources/res/sparksave/datasave - 副本.csv,1,jack,male,29
    2,linda,female,29
    ), (file:/D:/my/code/github/learncode/spark/src/main/resources/res/sparksave/datasave.csv,1,jack,male,29
    2,linda,female,29
    )]
    [1, jack, male, 29]
    [2, linda, female, 29]
    [1, jack, male, 29]
    [2, linda, female, 29]
 */
