package com.learning.designpattern.j2ee.mvc;

import com.learning.designpattern.j2ee.mvc.controller.StudentController;
import com.learning.designpattern.j2ee.mvc.model.Student;
import com.learning.designpattern.j2ee.mvc.view.StudentView;

public class MVCPatternDemo {
    public static void main(String[] args) {
        //fetch student record based on his rollNo from database
        Student model = retrieveStudentFromDb();

        //Create a view : to write student details on the console
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model,view);

        controller.updateView();

        //Update model data
        controller.setStudentName("John");

        controller.updateView();

    }

    private static Student retrieveStudentFromDb(){
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
