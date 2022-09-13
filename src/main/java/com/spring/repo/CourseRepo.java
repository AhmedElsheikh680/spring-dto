package com.spring.repo;

import com.spring.model.Course;
import com.spring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    @Query("select c.student from Course c where c.id= ?1")
    public Student findStudentByCourseID(Long id);

    @Query("select c from Course c where c.id in(:courseId)")
    public List<Course> getCoursesByIds(List<Long> courseId);
}
