package com.example.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_school_class")
@SequenceGenerator(name = "class_start", sequenceName = "class_start", initialValue = 3)

public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "class_start")
    private Integer classId;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "classId")
    private List<Student> students;

    @JsonIgnore
    @ManyToMany(mappedBy = "schoolClasses")
    private List<Course> courses = new ArrayList<>();
}
