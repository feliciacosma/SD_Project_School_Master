package com.example.project.business;

import com.example.project.model.Student;
import com.example.project.model.Teacher;
import com.example.project.persistance.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;

    //C - create operation
    public Teacher createTeacher(Teacher teacher) {
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        return teacherRepository.save(teacher);
    }

    //R - read operation
    public List<Teacher> readTeacher() {
        return teacherRepository.findAll();
    }

    //U - update operation
    public Teacher updateTeacher(Teacher teacher, Integer teacherId) {
        Teacher t = teacherRepository.findById(teacherId).get();

        if (Objects.nonNull(teacher.getUsername()) && !"".equalsIgnoreCase(teacher.getUsername())) {
            t.setUsername(teacher.getUsername());
        }

        if (Objects.nonNull(teacher.getPassword()) && !"".equalsIgnoreCase(teacher.getPassword())) {
            t.setPassword(passwordEncoder.encode(teacher.getPassword()));
        }

        if (Objects.nonNull(teacher.getEmail()) && !"".equalsIgnoreCase(teacher.getEmail())) {
            t.setEmail(teacher.getEmail());
        }

        if (Objects.nonNull(teacher.getFullName()) && !"".equalsIgnoreCase(teacher.getFullName())) {
            t.setFullName(teacher.getFullName());
        }

        return teacherRepository.save(t);
    }

    //D - delete operation
    public String deleteTeacher(Integer teacherId) {
        teacherRepository.deleteById(teacherId);
        return "Teacher deleted successfully.";
    }

    public Teacher findById(int id) {

        var val = teacherRepository.findById(id);

        if (val.isPresent()) {
            Teacher t = val.get();
            return t;
        } else return null;
    }

}
