package com.learn.java.javabase.designpattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class CloneResume01 extends Resume {
    private String name;
    private String age;
    private String year;
    private String workInfo;
    private Remark remark;

    //    public CloneResume01(Remark remark)
//    {
//        this.remark =remark.clone();
//    }
    public CloneResume01(String age, String name) {
        this.age = age;
        this.name = name;
    }

    public CloneResume01(String age, String name, Remark remark) {
        this.age = age;
        this.name = name;
        this.remark = remark;
    }

    public void setWorkInfo(String year, String workinfo) {
        this.year = year;
        this.workInfo = workinfo;
    }

    public void display() {
        log.info("name = {} ,age = {} , in year {}  {},remark ={}", name, age, year, workInfo, remark.toString());
    }

    @Override
    public CloneResume01 clone() {
        CloneResume01 cloneResume01 =null;
        try {
            cloneResume01 = (CloneResume01) super.clone();
            cloneResume01.setRemark(this.getRemark().clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloneResume01;
    }
}
