package com.learn.java.javabase.kafka;


import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Properties;
@Slf4j
public class Consumer {
    public static void main(String[] args) {
        //Logger.getLogger("org.apache.kafka").setLevel(Level.ERROR); //关掉idea控制台的日志
        Properties p = new Properties();
        //119.45.207.171:9092
        //p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.56.130:9092");
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "119.45.207.171:9092");
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        p.put(ConsumerConfig.GROUP_ID_CONFIG, "test3");
        p.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
        p.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(p);
        kafkaConsumer.subscribe(Collections.singletonList("test"));// 订阅消息
        System.out.println("begin consumer");
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
               // System.out.println(String.format("topic:%s,offset:%d,消息:%s", record.topic(), record.offset(), record.value()));
                log.info(String.format("topic:%s,offset:%d,消息:%s", record.topic(), record.offset(), record.value()));

            }
        }
    }
}
