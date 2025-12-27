package com.example.CourseWeb.service;

import com.example.CourseWeb.model.Course;
import com.example.CourseWeb.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;


    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Course getCourseBycourseId(Integer courseId) {
        return courseRepo.getCourseByCourseId(courseId);
    }

    public Course saveCourse(Course newCourse) {
        return courseRepo.save(newCourse);
    }
}
