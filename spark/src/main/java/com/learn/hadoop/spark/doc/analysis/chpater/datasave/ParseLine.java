package com.learn.hadoop.spark.doc.analysis.chpater.datasave;

import com.opencsv.CSVReader;
import org.apache.spark.api.java.function.FlatMapFunction;
import scala.Tuple2;

import java.io.StringReader;
import java.util.Iterator;

public class ParseLine implements FlatMapFunction<Tuple2<String,String>,String []> {
    @Override
    public Iterator<String[]> call(Tuple2<String, String> stringStringTuple2) throws Exception {
        CSVReader reader = new CSVReader(new StringReader(stringStringTuple2._2));
        return reader.readAll().iterator();
    }
}
