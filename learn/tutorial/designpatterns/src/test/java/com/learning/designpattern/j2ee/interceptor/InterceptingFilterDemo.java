package com.learning.designpattern.j2ee.interceptor;

import com.learning.designpattern.j2ee.interceptor.filter.AuthenticationFilter;
import com.learning.designpattern.j2ee.interceptor.filter.DebugFilter;
import com.learning.designpattern.j2ee.interceptor.filter.FilterManager;

public class InterceptingFilterDemo {

    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());

        FilterClient client = new FilterClient();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }
}
