package com.example.project.model.dto;

import com.example.project.model.SchoolClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer studentId;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private Integer class_id;
}
