package com.example.project.business;

import com.example.project.model.Role;
import com.example.project.model.SchoolClass;
import com.example.project.model.Situation;
import com.example.project.model.Student;
import com.example.project.model.dto.StudentDTO;
import com.example.project.persistance.StudentRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    private SchoolClassService schoolClassService;
    private final PasswordEncoder passwordEncoder;

    public Student toEntity(StudentDTO studentDTO) {
        SchoolClass schoolClass = schoolClassService.findById(studentDTO.getClass_id());
        return Student.builder()
                .studentId(studentDTO.getStudentId())
                .username(studentDTO.getUsername())
                .password(studentDTO.getPassword())
                .fullName(studentDTO.getFullName())
                .classId(schoolClass)
                .email(studentDTO.getEmail())
                .build();
    }

    public StudentDTO fromEntity(Student student) {
        return StudentDTO.builder()
                .studentId(student.getStudentId())
                .username(student.getUsername())
                .password(student.getPassword())
                .fullName(student.getFullName())
                .class_id(student.getClassId().getClassId())
                .email(student.getEmail())
                .build();
    }

    //C - create operation
    public Student createStudent(StudentDTO student) {
        Student s = toEntity(student);
        s.setPassword(passwordEncoder.encode(s.getPassword()));
        s.setRole(Role.STUDENT);
        return studentRepository.save(s);
    }

    //R - read operation
    public List<Student> readStudent() {
        return studentRepository.findAll();
    }

    //U - update operation
    public Student updateStudent(StudentDTO student, Integer studentId) {
        Student s = studentRepository.findById(studentId).get();
        StudentDTO studentDTO = fromEntity(s);

        if (Objects.nonNull(student.getUsername()) && !"".equalsIgnoreCase(student.getUsername())) {
            studentDTO.setUsername(student.getUsername());
        }

        if (Objects.nonNull(student.getPassword()) && !"".equalsIgnoreCase(student.getPassword())) {
            studentDTO.setPassword(passwordEncoder.encode(student.getPassword()));
        }

        if (Objects.nonNull(student.getEmail()) && !"".equalsIgnoreCase(student.getEmail())) {
            studentDTO.setEmail(student.getEmail());
        }

        if (Objects.nonNull(student.getFullName()) && !"".equalsIgnoreCase(student.getFullName())) {
            studentDTO.setFullName(student.getFullName());
        }

        if (Objects.nonNull(student.getClass_id()) && !"".equalsIgnoreCase(Integer.toString(student.getClass_id()))) {
            studentDTO.setClass_id(student.getClass_id());
        }

        Student st = toEntity(studentDTO);
        st.setRole(Role.STUDENT);
        return studentRepository.save(st);
    }

    //D - delete operation
    public String deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
        return "Student deleted successfully.";
    }

    public Student findById(int id) {

        var val = studentRepository.findById(id);

        if (val.isPresent()) {
            Student s = val.get();
            return s;
        } else return null;
    }
}
