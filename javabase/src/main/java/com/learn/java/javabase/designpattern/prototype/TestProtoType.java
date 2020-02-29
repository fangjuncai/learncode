package com.learn.java.javabase.designpattern.prototype;

public class TestProtoType {
    public static void main(String[] args) {
        CloneResume01 jackResume=new CloneResume01("fang","28","2017-2019","comp1"
                ,new Remark("first job"));
        CloneResume01 jackResume02=jackResume.clone();
        //Remark没有实现clone方法，下面这句话会因为是复制新的Remark对象,所以打印的Remark是不一样的
        //jackResume02.setRemark(new Remark("second job"));
        //浅复制和深复制,Remark和Resume实现类两个clone方法没有修改,会因为浅复制吗,导致拷贝的实例的值与原型的值是一样的
        jackResume02.getRemark().setRemarkValue("second job");
        jackResume02.setWorkInfo("2020-now","comp2");
        jackResume.display();
        jackResume02.display();
    }
}
