package com.learn.java.javabase.tmp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-06-08 20:59
 **/
@Slf4j
public class Test02 {
    public static void main(String[] args) throws Exception {
        // 需要处理数据的文件位置
            FileReader fileReader = new FileReader(new File("D:\\tt.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        String readLine = null;

        while ((readLine = bufferedReader.readLine()) != null) {
            // 每次读取一行数据，与 map 进行比较，如果该行数据 map 中没有，就保存到 map 集合中
            if (!wordsMap.containsValue(readLine)) {
                wordsMap.put(readLine, 1);
            }else {
                int count =wordsMap.get(readLine)+1;
                System.out.println(count);
                wordsMap.put(readLine,count );
            }
        }
       // wordsMap.forEach((k,v)->log.info("key {} ,value {}",k,v));
        Map<String, Integer> wordDupRemoveMap = new HashMap<String, Integer>();
        Iterator iterator = wordsMap.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String,Integer> entry = (Map.Entry<String, Integer>) iterator.next();
            if(entry.getKey().contains("Login")){
                wordDupRemoveMap.put(entry.getKey(),entry.getValue());
            }
        }
        //wordDupRemoveMap.forEach((k,v)->log.info("key {} ,value {}",k,v));
        Map<String, Integer> out = new TreeMap<>();
        wordDupRemoveMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x->out.put(x.getKey(),x.getValue())); //.forEach(x->out.put(x.getKey(),x.getValue()));
        //out.forEach((k,v)->log.info("key={} ,value ={}",k,v));
        out.forEach((k,v)-> {
            System.out.println("key= " + k + ",value= " + v);
        });
    }
}
