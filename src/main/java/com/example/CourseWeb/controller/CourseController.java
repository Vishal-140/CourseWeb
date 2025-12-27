package com.example.CourseWeb.controller;

import com.example.CourseWeb.model.Course;
import com.example.CourseWeb.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/allCourses")
    public ResponseEntity<List<Course>> getAllCourses(){
       return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourseBycourseId(@PathVariable Integer courseId) {
        Course c = courseService.getCourseBycourseId(courseId);
        if (c == null) {
            var logM = new HashMap<>();
            logM.put("Message", "Request Denied");
            List<String> errorList = new ArrayList<>();
            errorList.add("Could not find the given id");
            logM.put("Errors", errorList);
            return new ResponseEntity<>(logM, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


//    @GetMapping("/{courseId}")
//    public ResponseEntity<?> getCourseBycourseId(@Valid @PathVariable Integer courseId, Errors errors){
//        Course c = courseService.getCourseBycourseId(courseId);
//        return ResponseEntity.ok(courseService.getCourseBycourseId(courseId));
//    }

    @PostMapping("/")
    public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course newCourse){
        return ResponseEntity.ok(courseService.saveCourse(newCourse));
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<?> updateCourse(@RequestBody Course updatedCourse, @PathVariable Integer courseId){
        Course existingCourse = courseService.getCourseBycourseId(courseId);
        if(existingCourse == null){
            Map<String, Object> logM = new HashMap<>();
            logM.put("Message", "Request Denied");
            logM.put("Errors", List.of("Could not find the given id"));
            return new ResponseEntity<>(logM, HttpStatus.BAD_REQUEST);
        }
        existingCourse.setCourseName(updatedCourse.getCourseName());
        existingCourse.setCourseDescription(updatedCourse.getCourseDescription());

        courseService.saveCourse(existingCourse);
        return new ResponseEntity<>(existingCourse, HttpStatus.OK);
    }


    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer courseId) {
        Course existingCourse = courseService.getCourseBycourseId(courseId);
        if (existingCourse == null) {
            Map<String, Object> logM = new HashMap<>();
            logM.put("Message", "Request Denied");
            logM.put("Errors", List.of("Could not find the given id"));
            return new ResponseEntity<>(logM, HttpStatus.BAD_REQUEST);
        }

        courseService.deleteCourse(courseId); // Delete course
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Course deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
