package com.spring.service;

import com.spring.model.*;
import com.spring.repo.CourseRepo;
import com.spring.repo.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<StudentDTO> students() {
         List<Student> students = studentRepo.findAll();
         List<StudentDTO> studentDTOS = new ArrayList<>();
         for (int i=0; i<students.size(); i++) {
//             StudentDTO studentDTO = new StudentDTO();
//             studentDTO.setId(students.get(i).getId());
//             studentDTO.setName(students.get(i).getName());
            StudentDTO studentDTO =  modelMapper.map(students.get(i), StudentDTO.class);
             studentDTOS.add(studentDTO);

         }
         return studentDTOS;
    }

    public StudentResponse student(Long id) {
        Student student = studentRepo.findById(id).get();
//        StudentResponse studentResponse = new StudentResponse();
//        studentResponse.setName(student.getName());
//        return studentResponse;
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setPhone("011111111111111111111111");
        modelMapper.map(student, studentResponse);
       return studentResponse;
    }

    public StudentDTO getStudentCourses(List<Long> ids) {
//        StudentDTO studentDTO = new StudentDTO();
//        Student student = courseRepo.findStudentByCourseID(ids.get(0));
        StudentDTO studentDTO = modelMapper.map(courseRepo.findStudentByCourseID(ids.get(0)), StudentDTO.class);
//        studentDTO.setId(student.getId());
//        studentDTO.setName(student.getName());

//        List<Course> courses = courseRepo.getCoursesByIds(ids);
//        for (int i=0; i<courses.size(); i++) {
////            CourseDTO courseDTO = new CourseDTO();
////            courseDTO.setId(courses.get(i).getId());
////            courseDTO.setName(courses.get(i).getName());
//
//            CourseDTO courseDTO = modelMapper.map(courses.get(i), CourseDTO.class);
//            studentDTO.getCourses().add(courseDTO);
//
//        }
        return studentDTO;
    }
}
