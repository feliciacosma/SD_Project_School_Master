package com.example.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_situation")
@SequenceGenerator(name = "situation_start", sequenceName = "situation_start", initialValue = 3)

public class Situation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "situation_start")
    private Integer situationId;

    private Integer finalGrade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private Student student;
}
