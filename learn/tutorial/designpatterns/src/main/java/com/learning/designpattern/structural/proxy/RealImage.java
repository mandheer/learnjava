package com.learning.designpattern.structural.proxy;

public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(this.fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading from disk : "+fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying : "+this.fileName);
    }
}
