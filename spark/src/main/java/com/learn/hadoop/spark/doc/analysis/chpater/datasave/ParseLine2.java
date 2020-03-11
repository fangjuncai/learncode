package com.learn.hadoop.spark.doc.analysis.chpater.datasave;

import com.opencsv.CSVReader;
import org.apache.spark.api.java.function.Function;

import java.io.StringReader;

public class ParseLine2  implements Function<String,String []>
{

    @Override
    public String[] call(String s) throws Exception {
        CSVReader reader = new CSVReader(new StringReader(s));
        return reader.readNext();
    }
}
