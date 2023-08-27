package com.example.project.controller;

import com.example.project.business.StudentService;
import com.example.project.model.Student;
import com.example.project.model.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableMethodSecurity
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //C - create operation
    @PostMapping("/student/createStudent")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public Student createStudent(@RequestBody StudentDTO student) {
        return studentService.createStudent(student);
    }

    //R - read operation
    @GetMapping("/student/readStudent")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public List<Student> readStudent() {
        return studentService.readStudent();
    }

    //U - update operation
    @PutMapping("/student/updateStudent/{studentId}")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public Student updateStudent(@RequestBody StudentDTO student, @PathVariable("studentId") Integer studentId) {
        return studentService.updateStudent(student, studentId);
    }

    //D - delete operation
    @DeleteMapping("/student/deleteStudent/{studentId}")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public String deleteStudent(@PathVariable("studentId") Integer studentId) {
        return studentService.deleteStudent(studentId);
    }
}
