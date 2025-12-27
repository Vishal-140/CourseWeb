package com.example.CourseWeb.repo;

import com.example.CourseWeb.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {


    Course getCourseByCourseId(Integer courseId);
}
