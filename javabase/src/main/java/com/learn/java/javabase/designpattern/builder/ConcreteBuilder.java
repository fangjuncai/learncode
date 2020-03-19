package com.learn.java.javabase.designpattern.builder;

public class ConcreteBuilder extends Builder {
    private String buleprint;
    private String partA;
    private String partB;
    @Override
    public House build(){
        return new House(this.buleprint,this.partA,this.partB);
    }
    @Override
    public ConcreteBuilder buildPartA(String partA){
        this.partA = partA;
        return this;
    }
    @Override
    public ConcreteBuilder buildPartB(String partB){
        this.partB = partB;
        return this;
    }
    @Override
    public ConcreteBuilder buildBuleprint(String buleprint){
        this.buleprint = buleprint;
        return this;
    }
}
