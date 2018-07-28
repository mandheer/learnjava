package com.learning.designpattern.j2ee.servicelocator;

import com.learning.designpattern.j2ee.servicelocator.locator.ServiceLocator;
import com.learning.designpattern.j2ee.servicelocator.service.Service;

public class ServiceLocatorPatternDemo {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("Service1");
        service.execute();
        service = ServiceLocator.getService("Service2");
        service.execute();
        service = ServiceLocator.getService("Service1");
        service.execute();
        service = ServiceLocator.getService("Service2");
        service.execute();

    }
}
