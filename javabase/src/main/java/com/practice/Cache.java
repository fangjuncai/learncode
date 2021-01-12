package com.practice;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-10 20:50
 **/

public class Cache {

    private String key;
    private String value;
    private long time;
    private Long expire;

    public Cache(String key, String value, Long expire){
        this.time = System.currentTimeMillis();
        this.key = key;
        this.value = value;
        this.expire = expire;
    }

    public Integer expire(Long expire){
        this.time = System.currentTimeMillis();
        this.expire = expire;
        return 1;
    }

    public boolean isExpire(){

        return this.expire != null && (System.currentTimeMillis() - this.time > this.expire);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }
}