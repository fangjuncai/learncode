package com.learn.java.javabase.generic.classprogramm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Orange extends Fruit {
    String name;
    String other;
}
