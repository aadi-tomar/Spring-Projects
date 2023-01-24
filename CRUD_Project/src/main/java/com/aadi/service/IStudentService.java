package com.aadi.service;

import com.aadi.Utils.Student;

import java.util.List;

public interface IStudentService {
    List<Student> loadStudents();

    void saveStudent(Student student);
    Student getStudent(int id);

    void updateStudent(Student student);

    void deleteStudent(int id);
}
