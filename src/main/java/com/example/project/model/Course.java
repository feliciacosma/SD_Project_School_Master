package com.example.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_course")
@SequenceGenerator(name = "course_start", sequenceName = "course_start", initialValue = 3)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "course_start")
    private Integer courseId;
    private String name;
    private Integer hour;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacherId;

    @ManyToMany
    @JoinTable(
            name = "courses_classes",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "classId")
    )
    private List<SchoolClass> schoolClasses;
}
