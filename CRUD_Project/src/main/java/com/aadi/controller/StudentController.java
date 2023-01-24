package com.aadi.controller;

import com.aadi.DAO.IStudentDAO;
import com.aadi.Utils.Student;
import com.aadi.Utils.StudentDTO;
import com.aadi.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;
    List<Student> studentList;

    @GetMapping("/showStudent")
    public String getStudentList(Model model){

        studentList = studentService.loadStudents();
        model.addAttribute("students", studentList);
        return "student-list";
    }

    @GetMapping("/showAddStudent")
    public String showAddStudent(Model model){

        Student studentDTO = new Student();
        model.addAttribute("studentDTO", studentDTO);
        return "add-student";
    }


    @PostMapping("/save-student")
    public String saveStudent(Student student){

        System.out.println(student);
        //if user has id do a update else do an insert
        if(student.getId() == 0)
            studentService.saveStudent(student);
        else{
            studentService.updateStudent(student);
        }
        return "redirect:/showStudent";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("userId") int id, Model model){

        Student theStudent = studentService.getStudent(id);
        model.addAttribute("studentDTO", theStudent);
        return "add-student";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("userId") int id, Model model){
        studentService.deleteStudent(id);
        return "redirect:/showStudent";
    }


}
