package com.example.project.persistance;

import com.example.project.model.Situation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SituationRepository extends JpaRepository<Situation, Integer>, CrudRepository<Situation, Integer> {
}
