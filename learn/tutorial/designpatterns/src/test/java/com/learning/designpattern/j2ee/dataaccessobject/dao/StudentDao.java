package com.learning.designpattern.j2ee.dataaccessobject.dao;

import com.learning.designpattern.j2ee.dataaccessobject.model.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> getAllStudents();
    public Student getStudent(int rollNo);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
}
