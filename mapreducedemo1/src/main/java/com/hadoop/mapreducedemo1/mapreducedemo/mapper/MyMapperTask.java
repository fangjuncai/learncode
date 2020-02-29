package com.hadoop.mapreducedemo1.mapreducedemo.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class  MyMapperTask extends Mapper<LongWritable, Text, Text, IntWritable> {
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

