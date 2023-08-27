package com.example.project.controller;

import com.example.project.auth.AuthenticationRequest;
import com.example.project.auth.AuthenticationResponse;
import com.example.project.auth.RegisterRequest;
import com.example.project.business.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@EnableMethodSecurity
public class AuthenticationController {

    private final AuthenticationService service;

    //register administrator
    @PostMapping("/api/v1/auth/registerAdministrator")
    public ResponseEntity<AuthenticationResponse> registerA(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerAdministrator(request));
    }

    //register employee
    @PostMapping("/api/v1/auth/registerStudent")
    public ResponseEntity<AuthenticationResponse> registerS(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerStudent(request));
    }

    //register client
    @PostMapping("/api/v1/auth/registerTeacher")
    public ResponseEntity<AuthenticationResponse> registerT(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerTeacher(request));
    }

    //login administrator
    @PostMapping("/loginAdministrator")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity<AuthenticationResponse> loginA(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.loginAdministrator(request));
    }

    //login employee
    @PostMapping("/loginStudent")
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<AuthenticationResponse> loginS(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.loginStudent(request));
    }

    //login client
    @PostMapping("/loginTeacher")
    @PreAuthorize("hasAuthority('TEACHER')")
    public ResponseEntity<AuthenticationResponse> loginT(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.loginTeacher(request));
    }

}
