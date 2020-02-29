package com.learn.java.javabase.designpattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Remark implements Cloneable {
    private String remarkValue;

    @Override
    public Remark clone() {
        Remark remark = null;
        try {
            remark = (Remark) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return remark;
    }
    @Override
    public String toString(){
        return remarkValue;
    }

}
