package com.spring.controller;


import com.spring.model.Student;
import com.spring.model.StudentDTO;
import com.spring.model.StudentResponse;
import com.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentDTO> students() {
        return studentService.students();
    }

    @GetMapping("/student")
    public StudentResponse student(@RequestParam Long id) {
        return studentService.student(id);
    }

    @GetMapping("/student-courses")
    public StudentDTO getStudentCourses(@RequestParam List<Long> ids) {
        return  studentService.getStudentCourses(ids);
    }
}
