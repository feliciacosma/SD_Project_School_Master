package com.example.project.business;

import com.example.project.model.Course;
import com.example.project.model.SchoolClass;
import com.example.project.model.Teacher;
import com.example.project.persistance.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {


    @Autowired
    private CourseRepository courseRepository;
    private TeacherService teacherService;
    private SchoolClassService schoolClassService;
    public List<Course> readCourseForTeacher(Integer courseId) {
        Teacher teacher = teacherService.findById(courseId);
        List<Course> list = courseRepository.findAll();
        List<Course> finalList = new ArrayList<>();
        for (Course course : list)
            if (course.getTeacherId().equals(teacher)) {
                finalList.add(course);
            }
        return finalList;
    }

    public List<Course> readCourseForClass(Integer courseId) {
        SchoolClass schoolClass = schoolClassService.findById(courseId);
        List<Course> list = courseRepository.findAll();
        List<Course> finalList = new ArrayList<>();
        for (Course course : list)
            if (course.getTeacherId().equals(schoolClass)) {
                finalList.add(course);
            }
        return finalList;
    }
}
