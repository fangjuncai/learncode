package com.practice;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-10 20:58
 **/
import java.util.concurrent.ConcurrentHashMap;

public class CacheContainer {

    private ConcurrentHashMap<String, Cache> map;
    private Long limit = null;

    public CacheContainer(){
        this.map = new ConcurrentHashMap<>(16);
    }

    public CacheContainer(long limit){
        this.map = new ConcurrentHashMap<>(16);
        this.limit = limit;
    }


    public Integer set(String key, String value){
        return this.set(key, value, null);
    }

    public Integer set(String key, String value, Long expire){
        if (this.limit != null && this.map.size() >= this.limit){
            this.lazy();
            if (this.limit != null && this.map.size() >= this.limit){
                throw new RuntimeException("Container length exceeded！");
            }
        }
        this.map.put(key, new Cache(key, value, expire));
        return 1;
    }

    public String get(String key){
        if (this.map.containsKey(key)){
            if (this.map.get(key).isExpire()){
                this.map.remove(key);
                throw new RuntimeException("no such key!");
            }else {
                return this.map.get(key).getValue();
            }
        }else {
            throw new RuntimeException("no such key!");
        }
    }

    public Integer expire(String key, Long expire){
        int result = 0;
        if (this.map.containsKey(key)){
            if (this.map.get(key).isExpire()){
                this.map.remove(key);
            }else {
                result = this.map.get(key).expire(expire);
            }
        }
        return result;
    }


    private void lazy(){
        for (Cache cache: this.map.values()){
            if (cache.isExpire()){
                this.map.remove(cache);
            }
        }

    }


}
