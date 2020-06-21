package com.learn.hadoop.spark.wordcount;

import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.util.LongAccumulator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @program: spark
 * @description
 * @author: fangjc
 * @create: 2020-06-14 13:00
 **/
public class WordRddFuntion implements FlatMapFunction<Iterator<String>, String> {
    Broadcast<String> broadcast = BroadCastHolder.appNameCast;
    LongAccumulator longAccumulator;

    public WordRddFuntion(LongAccumulator longAccumulator) {
        this.longAccumulator = longAccumulator;
    }

    public WordRddFuntion() {
    }

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
}
