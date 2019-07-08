package com.learning.designpattern.j2ee.frontcontroller;

import com.learning.designpattern.j2ee.frontcontroller.controller.FrontController;

public class FrontControllerPatternDemo {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
    }
}
