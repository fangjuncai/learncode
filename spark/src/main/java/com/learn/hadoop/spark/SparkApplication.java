package com.learn.hadoop.spark;

import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Preconditions;
import com.learn.hadoop.spark.config.AppConfig;
import com.learn.hadoop.spark.wordcount.BroadCastHolder;
import com.learn.hadoop.spark.wordcount.SparkContextHolder;
import com.learn.hadoop.spark.wordcount.WordRddFuntion;
import lombok.extern.slf4j.Slf4j;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.util.LongAccumulator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.learn.hadoop.spark.config", "com.learn.hadoop.spark"},exclude = {GsonAutoConfiguration.class})
@Slf4j
public class SparkApplication {


    public static void main(String[] args) {

        SpringApplication.run(SparkApplication.class, args);


        log.info("start spark app");

        log.info("app.value.autowired.test :{}", AppConfig.appTestValue);
        if(null != System.getProperty("javaOptionFlag")){
            log.info("javaOptionFlag :{}",System.getProperty("javaOptionFlag"));
        }
        if(null != System.getProperty("javaOptionArg")){
            log.info("javaOptionArg :{}",System.getProperty("javaOptionArg"));
        }


        JavaSparkContext jsc = SparkContextHolder.javaSparkContext;
        Broadcast<String> broadcast = BroadCastHolder.appNameCast;
        log.info(" jsc :{}",jsc.appName());
        log.info("jsc bro value: {}",BroadCastHolder.appNameCast.getValue());

        JavaRDD<String> input =jsc.parallelize(Arrays.asList("a j k l","a b c","d e f"," x y z "));

        input = input.map(new Function<String, String>() {
            @Override
            public String call(String v1) throws Exception {
                if(v1.equals("a j k l")){
                    return null;
                }else{
                    return v1.toUpperCase();
                }


            }
        });
        input = input.filter(item->{
            if(null == item){
                return false;
            }else {
                return true;
            }
        });
        input.foreach(item ->{
            System.out.println(item.toString());

//            if(null!=item){
//                System.out.println(item.toString());
//            }else {
//                System.out.println("item is null");
//            }
        });
        System.out.println(input.collect().size());
        System.out.println(input.collect().toString());
/*


        input =input.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.trim().split(" ")).iterator();
            }
        });

        LongAccumulator longAccumulator = jsc.sc().longAccumulator();

        //JavaRDD<String> words1 = input.mapPartitions(new WordRddFuntion(longAccumulator));
        JavaRDD<String> words1 = input.mapPartitions(new FlatMapFunction<Iterator<String>, String>() {
            @Override
            public Iterator<String> call(Iterator<String> stringIterator) throws Exception {
                ArrayList<String> list = new ArrayList<>();
                while(stringIterator.hasNext()){
                    String  item  = stringIterator.next();
                    StringBuilder stringBuilder = new StringBuilder();
                    //将广播变量的值添加到列表中
                    //BroadCastHolder.appNameCast.getValue()) Serializable Null
                    stringBuilder.append(item).append("--").append(broadcast.getValue());

                    //stringBuilder.append(item).append("--");
                    list.add(stringBuilder.toString());
                    longAccumulator.add(1);
                }
                return list.iterator();
            }
        });
        List<String> wordout =words1.collect();
        Gson gson = new Gson();
        log.info("gson : {}",gson.toJson(wordout));
        wordout.forEach(item -> log.info(item));
        log.info("item number : {}",longAccumulator.value());
*/

        jsc.stop();
    }

}
