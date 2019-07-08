package com.learning.designpattern.j2ee.interceptor;

public class Target {
    public void execute(String request){
        System.out.println("executing request : "+request);
    }
}
