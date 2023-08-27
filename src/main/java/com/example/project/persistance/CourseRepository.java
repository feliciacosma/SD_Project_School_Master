package com.example.project.persistance;

import com.example.project.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>, CrudRepository<Course, Integer> {
}
