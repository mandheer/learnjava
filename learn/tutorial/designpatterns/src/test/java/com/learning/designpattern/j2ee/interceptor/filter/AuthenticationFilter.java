package com.learning.designpattern.j2ee.interceptor.filter;

public class AuthenticationFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("Authenticating Request : "+request);
    }
}
