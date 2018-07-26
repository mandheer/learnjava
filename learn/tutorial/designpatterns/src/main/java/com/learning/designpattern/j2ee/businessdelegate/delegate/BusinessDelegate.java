package com.learning.designpattern.j2ee.businessdelegate.delegate;

import com.learning.designpattern.j2ee.businessdelegate.lookup.BusinessLookUp;

public abstract class BusinessDelegate {
    protected BusinessLookUp lookupService = new BusinessLookUp();

    protected String serviceType;

    public abstract void doTask();

    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }

}
