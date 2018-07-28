package com.learning.designpattern.j2ee.interceptor;

import com.learning.designpattern.j2ee.interceptor.filter.FilterManager;

public class FilterClient {
    FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager){
        this.filterManager = filterManager;
    }

    public void sendRequest(String request){
        filterManager.filterRequest(request);
    }
}
