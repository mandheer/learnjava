package com.learning.designpattern.j2ee.servicelocator.locator;

import com.learning.designpattern.j2ee.servicelocator.cache.Cache;
import com.learning.designpattern.j2ee.servicelocator.context.InitialContext;
import com.learning.designpattern.j2ee.servicelocator.service.Service;

public class ServiceLocator {
    private static Cache cache;
    static {
        cache = new Cache();
    }

    public static Service getService(String jndiName){
        Service service = cache.getService(jndiName);

        if(service != null){
            return service;
        }

        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookup(jndiName);
        cache.addService(service1);
        return service1;
    }
}
