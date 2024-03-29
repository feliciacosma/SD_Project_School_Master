package com.example.project.persistance;

import com.example.project.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer>, CrudRepository<Student, Integer> {
    Optional<Student> findByUsername(String username);
}
