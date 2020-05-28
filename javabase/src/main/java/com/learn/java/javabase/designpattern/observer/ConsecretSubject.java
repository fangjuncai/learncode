package com.learn.java.javabase.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ConsecretSubject implements Subject {
    private List<Observer> observerList = new ArrayList<>();
    private String action;


    @Override
    public void attachObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void dettachObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> {
            System.out.println("----------");
            observer.update();
        });
    }

    @Override
    public String getAachtion() {
        return action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

}
