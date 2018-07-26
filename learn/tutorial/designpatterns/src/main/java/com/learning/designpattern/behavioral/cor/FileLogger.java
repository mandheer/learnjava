package com.learning.designpattern.behavioral.cor;

public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File Console :: Logger : "+message);
    }
}
