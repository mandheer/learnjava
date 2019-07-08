package com.learning.designpattern.structural.proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded into the disk
        image.display();
        System.out.println("");

        //image will not be loaded from the disk
        image.display();
    }
}
