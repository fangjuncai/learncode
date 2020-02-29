package com.hadoop.mapreducedemo.reduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
/**
        KEYIN 	对应的是map阶段的 KEYOUT
        VALUEIN 	对应的是map阶段的 VALUEOUT
        KEYOUT 	reduce逻辑处理的输出Key类型
        VALUEOUT 	reduce逻辑处理的输出Value类型
 */
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