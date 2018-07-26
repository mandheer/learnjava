package com.learning.designpattern.creational.singleton;

public class SingleObject {

    private static SingleObject _INSTANCE = new SingleObject();

    /**
     * private contructor for this singleton class
     */
    private SingleObject(){

    }

    public static SingleObject getInstance(){
        return _INSTANCE;
    }

    public void showMessage(){
        System.out.println("Inside SingleObject::showMessage() method.");
    }
}
