package com.aadi.DAO;

import com.aadi.Utils.Student;
import com.aadi.Utils.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAOImpl implements IStudentDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    String sqlSelect = "SELECT * from students";
    @Override
    public List<Student> loadStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList = jdbcTemplate.query(sqlSelect, new StudentRowMapper());
        return studentList;
    }

    @Override
    public void saveStudent(Student student) {
        Object[] arr = {student.getName(), student.getMobile(), student.getCountry()};
        String query = "INSERT into students(name, mobile, country) values (?,?,?)";
        jdbcTemplate.update(query, arr);
        System.out.println("Inserted student data into DB");
    }

    @Override
    public Student getStudent(int id) {
        String sql= "SELECT * from students where id = ?";
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper() ,id);
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name = ? , mobile = ? , country = ? where id = ?";
        Object[] args = {student.getName(), student.getMobile(), student.getCountry(), student.getId()};
        jdbcTemplate.update(sql, args);
        System.out.println("Record updated with id : " + student.getId() );
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE from students where id = ?";

        jdbcTemplate.update(sql, id);
    }
}
