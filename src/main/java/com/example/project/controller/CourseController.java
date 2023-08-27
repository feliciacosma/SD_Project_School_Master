package com.example.project.controller;

import com.example.project.business.CourseService;
import com.example.project.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableMethodSecurity
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course/readCourseForTeacher/{teacherId}")
    @PreAuthorize("hasAuthority('TEACHER')")
    public List<Course> readCourseForTeacher(@PathVariable("teacherId") Integer teacherId) {
        return courseService.readCourseForTeacher(teacherId);
    }

    @GetMapping("/course/readCourseForClass/{classId}")
    @PreAuthorize("hasAuthority('STUDENT')")
    public List<Course> readCourseForClass(@PathVariable("classId") Integer classId) {
        return courseService.readCourseForClass(classId);
    }
}
