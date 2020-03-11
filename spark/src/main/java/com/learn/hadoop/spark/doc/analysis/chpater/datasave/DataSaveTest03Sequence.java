package com.learn.hadoop.spark.doc.analysis.chpater.datasave;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.SequenceFileAsBinaryOutputFormat;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;

public class DataSaveTest03Sequence {
    public static void main(String[] args) {
        SparkConf conf =new SparkConf().setMaster("local").setAppName("DataSaveTest03Sequence");
        JavaSparkContext sc = new JavaSparkContext(conf);
        //序列化键值对
        JavaPairRDD<String,Integer> rdd = sc.parallelizePairs(Arrays.asList(new Tuple2<String,Integer>("string one",1),
                new Tuple2<String,Integer>("string two",2)),1);

        //返回SequenceFile所支持的格式的键值对
        JavaPairRDD<Text,IntWritable>  result = rdd.mapToPair(new PairFunction<Tuple2<String, Integer>, Text, IntWritable>() {
            @Override
            public Tuple2<Text, IntWritable> call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                return new Tuple2<Text, IntWritable>(new Text(stringIntegerTuple2._1),new IntWritable(stringIntegerTuple2._2));
            }
        });
        //输出键值对
        result.saveAsHadoopFile("C:\\Users\\juncai\\Desktop\\out", Text.class,
                IntWritable.class, SequenceFileOutputFormat.class);

        //test read
        String filepath = "D:\\my\\code\\github\\learncode\\spark\\src\\main\\resources\\res\\saprksavesequence\\part-00000";
        //SequenceFile是键值对的hadoop文件
        //直接读取hadoop文件，转化为hadoop键值对
        JavaPairRDD<Text,IntWritable> input = sc.sequenceFile(filepath,Text.class,IntWritable.class,1);
        input.foreach(f-> System.out.println(f.toString()));
        //转为普通的键值对。maiToPair是键值对转换函数
        JavaPairRDD<String ,Integer> outRdd = input.mapToPair(new PairFunction<Tuple2<Text, IntWritable>, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(Tuple2<Text, IntWritable> textIntWritableTuple2) throws Exception {
                return new Tuple2<String, Integer>(textIntWritableTuple2._1.toString(),textIntWritableTuple2._2.get());
            }
        });
        outRdd.foreach(f-> System.out.println(f.toString()));
    }
}
