package com.learn.java.javabase.designpattern.observer;

public class ObserverClient {
    public static void main(String[] args) {
        Subject subject01 = new ConsecretSubject();
        Observer observer01 = new ConsecretObserver(subject01,"observer01");
        Observer observer02 = new ConsecretObserver(subject01,"observer02");
        Observer observer03 = new ConsecretObserver(subject01,"observer03");

        subject01.setAction("topic01");
        subject01.attachObserver(observer01);
        subject01.attachObserver(observer02);
        subject01.attachObserver(observer03);
        subject01.notifyObservers();

        subject01.setAction("topic02");
        subject01.dettachObserver(observer01);
        subject01.notifyObservers();

    }
}
