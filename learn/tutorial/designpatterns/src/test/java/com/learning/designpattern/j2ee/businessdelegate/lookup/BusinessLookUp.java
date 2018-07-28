package com.learning.designpattern.j2ee.businessdelegate.lookup;

import com.learning.designpattern.j2ee.businessdelegate.service.BusinessService;
import com.learning.designpattern.j2ee.businessdelegate.service.EJBService;
import com.learning.designpattern.j2ee.businessdelegate.service.JMSService;

public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType){
        if(serviceType.equals("EJB")){
            return new EJBService();
        } else {
            return new JMSService();
        }
    }
}
