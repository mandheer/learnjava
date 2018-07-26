package com.learning.designpattern.behavioral.nullobject;

public class CustomerFactory {
    public static final String names[] = {"Rob", "Joe", "Julie"};

    public static AbstractCustomer getCustomer(String name){
        for(String str:names){
            if(str.equalsIgnoreCase(name)){
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
