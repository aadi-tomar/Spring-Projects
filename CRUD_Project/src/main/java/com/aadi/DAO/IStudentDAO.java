package com.aadi.DAO;

import com.aadi.Utils.Student;

import java.util.List;

public interface IStudentDAO {

    List<Student> loadStudents();
    void saveStudent(Student student);

    Student getStudent(int id);

    void updateStudent(Student student);

    void deleteStudent(int id);
}
