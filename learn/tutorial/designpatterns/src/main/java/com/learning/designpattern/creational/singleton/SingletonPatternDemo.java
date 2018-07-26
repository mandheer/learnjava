package com.learning.designpattern.creational.singleton;

public class SingletonPatternDemo {
    public static void main(String[] args){

        //illegal construct
        //Compile time error : The constructor Single Object is not visible
        //SingleObject object = new SingleObject();

        //Get the only object available
        SingleObject object = SingleObject.getInstance();

        //Show the message
        object.showMessage();
    }
}
