package com.example.project.business;

import com.example.project.model.SchoolClass;
import com.example.project.persistance.SchoolClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SchoolClassService {

    @Autowired
    private SchoolClassRepository schoolClassRepository;
    public SchoolClass findById(int id) {

        var val = schoolClassRepository.findById(id);

        if (val.isPresent()) {
            SchoolClass s = val.get();
            return s;
        } else return null;
    }
}
