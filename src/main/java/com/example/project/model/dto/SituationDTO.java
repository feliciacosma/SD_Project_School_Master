package com.example.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SituationDTO {

    private Integer situationId;
    private Integer finalGrade;
    private Integer student_id;
}
