package com.learning.designpattern.j2ee.businessdelegate.service;

public class JMSService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking JMS Service");
    }
}
