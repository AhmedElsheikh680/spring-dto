package com.spring.service;

import com.spring.model.Student;
import com.spring.model.StudentDTO;
import com.spring.model.StudentResponse;
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
       StudentResponse studentResponse =  modelMapper.map(student, StudentResponse.class);
       return studentResponse;
    }
}
