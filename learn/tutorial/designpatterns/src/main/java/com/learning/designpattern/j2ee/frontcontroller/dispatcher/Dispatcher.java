package com.learning.designpattern.j2ee.frontcontroller.dispatcher;

import com.learning.designpattern.j2ee.frontcontroller.view.HomeView;
import com.learning.designpattern.j2ee.frontcontroller.view.StudentView;

public class Dispatcher {
    private StudentView studentView;
    private HomeView homeView;

    public Dispatcher(){
        studentView = new StudentView();
        homeView = new HomeView();
    }

    public void dispatch(String request){
        if (request.equalsIgnoreCase("STUDENT")){
            studentView.show();
        } else {
            homeView.show();
        }
    }

}
