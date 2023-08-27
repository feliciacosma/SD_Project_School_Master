package com.example.project.business;

import com.example.project.model.Situation;
import com.example.project.model.Student;
import com.example.project.model.dto.SituationDTO;
import com.example.project.persistance.SituationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class SituationService {

    private SituationRepository situationRepository;
    private StudentService studentService;
    public Situation toEntity(SituationDTO situationDTO) {
        Student student = studentService.findById(situationDTO.getStudent_id());
        return Situation.builder()
                .situationId(situationDTO.getSituationId())
                .finalGrade(situationDTO.getFinalGrade())
                .student(student)
                .build();
    }

    public SituationDTO fromEntity(Situation situation) {
        return SituationDTO.builder()
                .situationId(situation.getSituationId())
                .finalGrade(situation.getFinalGrade())
                .student_id(situation.getStudent().getStudentId())
                .build();
    }

    //C - create operation
    public Situation createSituation(SituationDTO situation) {
        Situation s = toEntity(situation);
        return situationRepository.save(s);
    }

    //R - read operation
    public List<Situation> readSituation() {
        return situationRepository.findAll();
    }

    //U - update operation
    public Situation updateSituation(SituationDTO situation, Integer situationId) {
        Situation s = situationRepository.findById(situationId).get();
        SituationDTO situationDTO = fromEntity(s);

        if (Objects.nonNull(situation.getFinalGrade()) && !"".equalsIgnoreCase(Integer.toString(situation.getFinalGrade()))) {
            situationDTO.setFinalGrade(situation.getFinalGrade());
        }

        if (Objects.nonNull(situation.getStudent_id()) && !"".equalsIgnoreCase(Integer.toString(situation.getStudent_id()))) {
            situationDTO.setStudent_id(situation.getStudent_id());
        }

        return situationRepository.save(toEntity(situationDTO));
    }

    //D - delete operation
    public String deleteSituation(Integer situationId) {
        situationRepository.deleteById(situationId);
        return "Student deleted successfully.";
    }

    public Situation findById(int id) {

        var val = situationRepository.findById(id);

        if (val.isPresent()) {
            Situation s = val.get();
            return s;
        } else return null;
    }
}
