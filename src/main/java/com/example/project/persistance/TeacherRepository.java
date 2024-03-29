package com.example.project.persistance;

import com.example.project.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>, CrudRepository<Teacher, Integer> {
    Optional<Teacher> findByUsername(String username);
}
