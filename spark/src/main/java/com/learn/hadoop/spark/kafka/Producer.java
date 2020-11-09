package com.learn.hadoop.spark.kafka;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Producer {
    public static String topic = "test2";//定义主题

    public static void main(String[] args) throws InterruptedException {
        Logger.getLogger("org.apache.kafka").setLevel(Level.ERROR); //关掉idea控制台的日志

        Properties producerPro = new Properties();
        producerPro.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.56.130:9092");//kafka地址，多个地址用逗号分割
        producerPro.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerPro.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(producerPro);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String msg = "Hello," + LocalDateTime.now().toString();
                        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, msg);
                        kafkaProducer.send(record);
                        System.out.println("消息发送成功:" + msg);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    kafkaProducer.close();
                }
            }
        }).start();

        Thread.sleep(10000);
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.56.130:9092");
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.GROUP_ID_CONFIG, "test1g1"+System.currentTimeMillis());
        p.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true");
        //p.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest");
        p.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(p);
        kafkaConsumer.subscribe(Collections.singletonList(Producer.topic));// 订阅消息

        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(String.format("topic:%s,offset:%d,消息:%s", //
                        record.topic(), record.offset(), record.value()));
            }
        }

    }
}