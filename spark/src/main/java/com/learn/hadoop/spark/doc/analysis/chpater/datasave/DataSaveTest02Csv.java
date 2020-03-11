package com.learn.hadoop.spark.doc.analysis.chpater.datasave;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

public class DataSaveTest02Csv {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("DataSaveTest02");
        JavaSparkContext sc  = new JavaSparkContext(conf);
        String inputfile = "D:\\my\\code\\github\\learncode\\spark\\src\\main\\resources\\res\\sparksave\\";
        //读取文件或者文件夹下所有文件，以每行记录读取
        JavaRDD<String> rdd = sc.textFile(inputfile);
        //打印读取的内容，打印出来的是所有行的string
        System.out.println(rdd.collect().toString());
        //JavaRDD<String[]> csvData =rdd.map(new ParseLine2());
        JavaRDD<String[]> csvData =rdd.map(new Function<String, String[]>() {
            @Override
            public String[] call(String s) throws Exception {
                CSVReader reader = new CSVReader(new StringReader(s));
                return reader.readNext();
            }
        });
        //输出csv 每行的数组
        csvData.foreach(f-> System.out.println(Arrays.asList(f).toString()));

        //test write
        String outfile ="C:\\Users\\juncai\\Desktop\\out";
        //创建一个JavaRDD<String []>，直接就赋值
        JavaRDD<String []> outrdd =csvData;
        //一行一行的去存
        outrdd.map(new Function<String[],String>(){
            @Override
            public String call(String[] strings) throws Exception {
                StringWriter stringWriter = new StringWriter();
                CSVWriter csvWriter = new CSVWriter(stringWriter);
                csvWriter.writeNext(strings);
                return stringWriter.toString();
            }
        }).saveAsTextFile(outfile);
    }
}
/*
目录下两个文件，相同的内容
    1,jack,male,29
    2,linda,female,29

输出
    [1,jack,male,29, 2,linda,female,29, 1,jack,male,29, 2,linda,female,29]
    [1, jack, male, 29]
    [2, linda, female, 29]
    [1, jack, male, 29]
    [2, linda, female, 29]
 */
