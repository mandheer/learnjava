package com.learning.designpattern.j2ee.businessdelegate.delegate;

import com.learning.designpattern.j2ee.businessdelegate.service.BusinessService;

public class BusinessDelegateImpl extends BusinessDelegate {

    private BusinessService businessService;

    @Override
    public void doTask(){
        businessService = lookupService.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}
