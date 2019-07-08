package com.learning.designpattern.behavioral.nullobject;

public class NullCustomer extends AbstractCustomer {
    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "Not available in Customer Database.";
    }
}
