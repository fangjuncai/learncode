package com.learn.hadoop.spark.doc.analysis.chpater.rdd;

import org.apache.hadoop.mapred.lib.MultipleTextOutputFormat;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @program: spark
 * @description
 * @author: fangjc
 * @create: 2020-06-10 22:04
 **/
public class MyMultipleTextOutputFormat extends MultipleTextOutputFormat<String, Integer> {

    @Override
    protected String generateFileNameForKeyValue(String key, Integer value, String name) {
        //return super.generateFileNameForKeyValue(key, value, name);
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/mm/dd"))
                + File.separator + key + File.separator + value;
    }

}