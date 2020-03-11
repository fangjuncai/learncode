    package com.learn.hadoop.spark.doc.analysis.chpater.rdd;

    import org.apache.spark.HashPartitioner;
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

    /**
     * RDD分区
     *HashPartitioner
     */
    public class RddTest05 {
        public static void main(String[] args) {
            SparkConf sparkConf =new SparkConf().setMaster("local[*]").setAppName("RddTest05");
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
            wordredues=wordredues.sortByKey(true);
            wordredues.foreach(stringIntegerTuple2 -> System.out.println(stringIntegerTuple2));
            //sorkByKey的分区器是RangerPartitioner
            System.out.println("after sort partitioner num: "+wordredues.getNumPartitions());
            System.out.println("after sort partitioner . partitioner : " +
                    ""+wordredues.partitioner().toString());

            //设置HashPartitioner,分区数与最后RDD计算有关系，sortByKey后的分区变为5
            wordredues =wordredues.partitionBy(new HashPartitioner(wordredues.getNumPartitions()));
            System.out.println("after set hash partitioner . partitioner num :"+wordredues.getNumPartitions());
            System.out.println("after set hash partitioner . partitioner :"+wordredues.partitioner().toString());

        }
    }

