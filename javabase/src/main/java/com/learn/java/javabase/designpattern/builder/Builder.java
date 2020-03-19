package com.learn.java.javabase.designpattern.builder;

public abstract class Builder {
    public abstract Builder buildPartA(String partA);
    public abstract Builder buildPartB(String part);
    public abstract Builder buildBuleprint(String buleprint);
    public abstract House build();
}
