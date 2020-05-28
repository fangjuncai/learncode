package com.learn.java.javabase.designpattern.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ConsecretObserver implements Observer {


    private Subject subject;
    private String name;

    @Override
    public void update() {
        if (subject != null && subject.getAachtion() != null) {
            System.out.println(name + " recive topic :");
            System.out.println("topic is :" + subject.getAachtion());
        }

    }
}
