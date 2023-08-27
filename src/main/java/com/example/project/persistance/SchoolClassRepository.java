package com.example.project.persistance;

import com.example.project.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer>, CrudRepository<SchoolClass, Integer> {
}
