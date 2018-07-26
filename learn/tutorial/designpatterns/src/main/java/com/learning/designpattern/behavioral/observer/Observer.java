package com.learning.designpattern.behavioral.observer;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
