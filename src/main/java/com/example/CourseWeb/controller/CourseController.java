package com.example.CourseWeb.controller;

import com.example.CourseWeb.model.Course;
import com.example.CourseWeb.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/allCourses")
    public List<Course> getAllCourses(){
       return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public Course getCourseBycourseId(@PathVariable Integer courseId){
        return courseService.getCourseBycourseId(courseId);
    }

    @PostMapping("/")
    public Course saveCourse(@RequestBody Course newCourse){
        return courseService.saveCourse(newCourse);
    }
}
