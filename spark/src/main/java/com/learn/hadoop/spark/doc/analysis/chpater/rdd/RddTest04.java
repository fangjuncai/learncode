package com.learn.hadoop.spark.doc.analysis.chpater.rdd;

import org.apache.spark.HashPartitioner;
import org.apache.spark.RangePartitioner;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.rdd.RDD;
import scala.Function1;
import scala.Tuple2;
import scala.runtime.BoxedUnit;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 如果读取的数据是hdfs，可以不设置分区器，因为默认文件的大小是128m，已经分区。参考https://www.cnblogs.com/qingyunzong/p/8987065.html
 * [自定义分区划分器](参考https://www.jianshu.com/p/e62985ffcb5f)
 * 设置HashPatitioner  RangerPartitioner
 */
public class RddTest04 {

    public static void main(String[] args) {
        SparkConf sparkConf =new SparkConf().setMaster("local[*]").setAppName("RddTest04");
        JavaSparkContext sc =new JavaSparkContext(sparkConf);
        JavaRDD<String> rdd =sc.parallelize(Arrays.asList("hello spark world ","hello java world","hello python world"));

        //设置当前分区数与cpu core有关
        System.out.println("local partitions:");
        System.out.println("rdd partitions num "+rdd.getNumPartitions());
        System.out.println("rdd partitioner :"+rdd.partitioner().toString());

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
        System.out.println("wordPairs partitioner :"+wordPairs.partitioner().toString());

        //归纳redues
        JavaPairRDD<String,Integer> wordredues = wordPairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer+integer2;
            }
        });
        //reduceByKey默认的分区器就是HashPartitioner
        System.out.println("wordredues partitioner num: "+wordredues.getNumPartitions());
        System.out.println("wordredues partitioner :"+wordredues.partitioner().toString());

        //输出字符统计
        System.out.println("console all");
        wordredues.foreach(stringIntegerTuple2 -> System.out.println(stringIntegerTuple2));

        //测试默认排序,默认是ascending(上升)true，如果sortByKey参数是false则是降序
        System.out.println("test sort:");
        wordredues=wordredues.sortByKey(true,wordredues.getNumPartitions());
        wordredues.foreach(stringIntegerTuple2 -> System.out.println(stringIntegerTuple2));
        //sorkByKey的分区器是RangerPartitioner
        System.out.println("after sort partitioner num: "+wordredues.getNumPartitions());
        System.out.println("after sort partitioner . partitioner : " +
                ""+wordredues.partitioner().toString());

        //设置HashPartitioner
        wordredues =wordredues.partitionBy(new HashPartitioner(wordredues.getNumPartitions()));
        System.out.println("after set hash partitioner . partitioner num :"+wordredues.partitioner().toString());
        System.out.println("after set hash partitioner . partitioner :"+wordredues.partitioner().toString());


        //设置RangePartitioner
        RDD<Tuple2<String, Integer>> prdd = JavaPairRDD.toRDD(wordredues);
        System.out.println("prdd = "+prdd.collect());

        RangePartitioner rangePartitioner = new RangePartitioner(
                //4,
                wordredues.getNumPartitions(),
                prdd,//待排序元 rdd
                true,//升序
                scala.math.Ordering.String$.MODULE$,//排序类型
                scala.reflect.ClassTag$.MODULE$.apply(String.class));//key

        //指定分区划分器
        JavaPairRDD<String, Integer> rangePartitionRDD = wordredues.partitionBy(rangePartitioner);
        System.out.println("partitionBy后分区数：" + rangePartitionRDD.getNumPartitions());
        System.out.println("partitionBy后分区划分器：" + rangePartitionRDD.partitioner().toString());
    }

}
