package com.learn.java.javabase.designpattern.prototype;

import lombok.Data;

@Data
public class Resume implements Cloneable {
    private String id;

    @Override
    public Resume clone() throws CloneNotSupportedException {
        Resume resume = null;
        resume = (Resume) super.clone();
        return resume;
    }
}
