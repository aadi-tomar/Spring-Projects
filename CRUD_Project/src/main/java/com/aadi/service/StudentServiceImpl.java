package com.aadi.service;

import com.aadi.DAO.IStudentDAO;
import com.aadi.Utils.Student;
import com.aadi.Utils.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {


    @Autowired
    IStudentDAO studentDao;
    @Override
    public List<Student> loadStudents() {
        List<Student> studentList = studentDao.loadStudents();
        return studentList;
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    public Student getStudent(int id) {
        return studentDao.getStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }
}
