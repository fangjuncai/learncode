package com.learn.hadoop.spark.doc.analysis.chpater.sreaming;

import org.apache.spark.streaming.Time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class StreamingTest02 {
    public static void main(String[] args) {
        test();
    }
    public static void test()
    {
        System.out.println(System.currentTimeMillis());
        Time time =new Time(System.currentTimeMillis());
        System.out.println(time.toString());
        System.out.println( Instant.ofEpochMilli(time.milliseconds()).atZone(ZoneId.systemDefault()).toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyyMMdd/HH/mm/ssSSS"))
        );
    }
}
