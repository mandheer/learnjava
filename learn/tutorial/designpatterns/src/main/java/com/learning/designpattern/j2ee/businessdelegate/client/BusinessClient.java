package com.learning.designpattern.j2ee.businessdelegate.client;

import com.learning.designpattern.j2ee.businessdelegate.delegate.BusinessDelegate;

public class BusinessClient {
    BusinessDelegate businessService;

    public BusinessClient(BusinessDelegate businessService){
        this.businessService = businessService;
    }

    public void doTask(){
        businessService.doTask();
    }
}
