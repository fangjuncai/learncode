package com.hadoop.mapreducedemo1.mapreducedemo.reduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MyReducerTask extends Reducer<Text, IntWritable, Text, IntWritable> {
    /**
     * @param key     map阶段输出的key
     * @param values  map阶段输出的相同的key对应的数据集
     * @param context 上下文
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        // 统计同一个key下的单词的个数
        for (IntWritable value : values) {
            count += value.get();
        }
        context.write(key, new IntWritable(count));
    }
}