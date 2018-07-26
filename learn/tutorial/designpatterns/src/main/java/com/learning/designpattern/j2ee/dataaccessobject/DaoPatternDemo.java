package com.learning.designpattern.j2ee.dataaccessobject;

import com.learning.designpattern.j2ee.dataaccessobject.dao.StudentDao;
import com.learning.designpattern.j2ee.dataaccessobject.dao.StudentDaoImpl;
import com.learning.designpattern.j2ee.dataaccessobject.model.Student;

public class DaoPatternDemo {
    public static void main(String[] args) {
        StudentDao dao = new StudentDaoImpl();

        //print all students
        for(Student student:dao.getAllStudents()){
            System.out.println("Student : [Roll No: "+student.getRollNo()+", Name: "+student.getName()+" ]");
        }

        //update student
        Student student = dao.getAllStudents().get(0);
        student.setName("Michel");
        dao.updateStudent(student);

        //get the student
        dao.getStudent(0);
        System.out.println("Student : [Roll No: "+student.getRollNo()+", Name: "+student.getName()+" ]");
    }
}
