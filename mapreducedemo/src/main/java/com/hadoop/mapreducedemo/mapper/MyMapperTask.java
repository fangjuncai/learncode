package com.hadoop.mapreducedemo.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
/**
 * 注意数据经过网络传输，所以需要序列化
 *
 * KEYIN:默认是一行一行读取的偏移量  long LongWritable
 * VALUEIN:默认读取的一行的类型 String
 *
 * KEYOUT:用户处理完成后返回的数据的key String LongWritable
 * VALUEOUT:用户处理完成后返回的value integer IntWritable
 */

public class  MyMapperTask extends Mapper<LongWritable, Text, Text, IntWritable> {
    /**
     * Map阶段的业务逻辑写在Map方法中
     * 默认是 每读取一行记录就会调用一次该方法
     * @param key 读取的偏移量
     * @param value 读取的那行数据
     */
    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        // 根据空格切割单词
        String[] words = line.split(" ");
        for (String word : words) {
            // 将单词作为key 将1作为值 以便于后续的数据分发
            context.write(new Text(word), new IntWritable(1));
        }
    }
}

