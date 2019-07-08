package com.learning.designpattern.j2ee.compositeentity;

public class CompositeEntityPatternDemo {
    public static void main(String[] args) {
        EntityClient client = new EntityClient();
        client.setData("First Test","First Data");
        client.printData();
        client.setData("Second Test", "Second Data");
        client.printData();
    }
}
