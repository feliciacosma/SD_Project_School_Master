package com.example.project.business;

import com.example.project.auth.AuthenticationRequest;
import com.example.project.auth.AuthenticationResponse;
import com.example.project.auth.RegisterRequest;
import com.example.project.configuration.JwtService;
import com.example.project.model.Administrator;
import com.example.project.model.Role;
import com.example.project.model.Student;
import com.example.project.model.Teacher;
import com.example.project.persistance.AdministratorRepository;
import com.example.project.persistance.StudentRepository;
import com.example.project.persistance.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Component
public class AuthenticationService {

    private final StudentRepository studentRepository;
    private final AdministratorRepository administratorRepository;
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService service;
    private final AuthenticationManager manager;

    //for administrator - register and login
    public AuthenticationResponse registerAdministrator(RegisterRequest request) {
        var administrator = Administrator.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMINISTRATOR)
                .email(request.getEmail())
                .fullName(request.getFullName())
                .build();
        administratorRepository.save(administrator);
        var token = service.generateToken(administrator);
        return AuthenticationResponse.builder().token(token).build();
    }

    public AuthenticationResponse loginAdministrator(AuthenticationRequest request) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = administratorRepository.findByUsername(request.getUsername()).orElseThrow();
        var token = service.generateToken(user);
        return AuthenticationResponse.builder().token(token).build();
    }

    //for student - register and login
    public AuthenticationResponse registerStudent(RegisterRequest request) {
        var student = Student.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.STUDENT)
                .email(request.getEmail())
                .fullName(request.getFullName())
                .build();
        studentRepository.save(student);
        var token = service.generateToken(student);
        return AuthenticationResponse.builder().token(token).build();
    }

    public AuthenticationResponse loginStudent(AuthenticationRequest request) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = studentRepository.findByUsername(request.getUsername()).orElseThrow();
        var token = service.generateToken(user);
        return AuthenticationResponse.builder().token(token).build();
    }

    //for teacher - register and login
    public AuthenticationResponse registerTeacher(RegisterRequest request) {
        var teacher = Teacher.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.TEACHER)
                .email(request.getEmail())
                .fullName(request.getFullName())
                .build();

        teacherRepository.save(teacher);
        var token = service.generateToken(teacher);
        return AuthenticationResponse.builder().token(token).build();
    }


    public AuthenticationResponse loginTeacher(AuthenticationRequest request) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = teacherRepository.findByUsername(request.getUsername()).orElseThrow();
        var token = service.generateToken(user);
        return AuthenticationResponse.builder().token(token).build();
    }
}
