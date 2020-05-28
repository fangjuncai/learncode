package com.learn.java.javabase.designpattern.observer;

/**
 * 主题接口
 */
public interface Subject {
    void attachObserver(Observer observer);
    void dettachObserver(Observer observer);
    void notifyObservers();
    String getAachtion();
    void setAction(String action);
}
