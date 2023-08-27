package com.example.project.controller;

import com.example.project.business.TeacherService;
import com.example.project.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableMethodSecurity
public class TeacherController {
    @Autowired
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //C - create operation
    @PostMapping("/teacher/createTeacher")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    //R - read operation
    @GetMapping("/teacher/readTeacher")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public List<Teacher> readTeacher() {
        return teacherService.readTeacher();
    }

    //U - update operation
    @PutMapping("/teacher/updateTeacher/{teacherId}")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable("teacherId") Integer teacherId) {
        return teacherService.updateTeacher(teacher, teacherId);
    }

    //D - delete operation
    @DeleteMapping("/teacher/deleteTeacher/{teacherId}")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public String deleteTeacher(@PathVariable("teacherId") Integer teacherId) {
        return teacherService.deleteTeacher(teacherId);
    }
}
