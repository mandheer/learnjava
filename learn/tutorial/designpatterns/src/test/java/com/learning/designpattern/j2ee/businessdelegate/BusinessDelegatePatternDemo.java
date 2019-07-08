package com.learning.designpattern.j2ee.businessdelegate;

import com.learning.designpattern.j2ee.businessdelegate.client.BusinessClient;
import com.learning.designpattern.j2ee.businessdelegate.delegate.BusinessDelegate;
import com.learning.designpattern.j2ee.businessdelegate.delegate.BusinessDelegateImpl;

public class BusinessDelegatePatternDemo {
    public static void main(String[] args) {
        BusinessDelegate businessDelegate = new BusinessDelegateImpl();
        businessDelegate.setServiceType("EJB");

        BusinessClient businessClient = new BusinessClient(businessDelegate);
        businessClient.doTask();

        businessDelegate.setServiceType("JMS");
        businessClient.doTask();

    }
}
