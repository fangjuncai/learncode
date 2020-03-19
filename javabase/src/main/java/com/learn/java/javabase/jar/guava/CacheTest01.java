package com.learn.java.javabase.jar.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public class CacheTest01 {
    public static void main(String[] args) {
        test01();
    }
    private static void test01(){
        Cache <String,String> cache = CacheBuilder.newBuilder().maximumSize(2)
                .removalListener(new RemovalListener<String, String>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, String> removalNotification) {
                        //移除监听器，监听移除动作
                        System.out.println("remove "+ removalNotification.getKey()+" ： "+removalNotification.getValue());
                    }
                })
                .build();

        //超过maxnum，会删除前面插入的记录
        cache.put("key1","value1");
        cache.put("key2","value2");
        cache.put("key3","value3");
        System.out.println(cache.getIfPresent("key1"));
        System.out.println(cache.getIfPresent("key2"));
        System.out.println(cache.getIfPresent("key3"));

        //显式清除
        cache.invalidate("key2");
        System.out.println(cache.getIfPresent("key2"));
    }
}
