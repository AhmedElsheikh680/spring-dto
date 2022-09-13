package com.spring.service;


import com.spring.model.Course;
import com.spring.model.CourseDTO;
import com.spring.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public List<CourseDTO> courses() {
        List<Course> courses= courseRepo.findAll();
        List<CourseDTO> courseDTOS = new ArrayList<>();
        for (int i=0; i<courses.size(); i++){
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(courses.get(i).getId());
            courseDTO.setName(courses.get(i).getName());
//            courseDTO.setCost(courses.get(i).getCost());
            courseDTOS.add(courseDTO);
        }
        return courseDTOS;
    }
}
