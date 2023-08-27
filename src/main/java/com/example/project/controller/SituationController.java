package com.example.project.controller;

import com.example.project.business.SituationService;
import com.example.project.model.Situation;
import com.example.project.model.dto.SituationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableMethodSecurity
public class SituationController {
    @Autowired
    private SituationService situationService;

    public SituationController(SituationService situationService) {
        this.situationService = situationService;
    }

    //C - create operation
    @PostMapping("/situation/createSituation")
    @PreAuthorize("hasAuthority('TEACHER')")
    public Situation createSituation(@RequestBody SituationDTO situation) {
        return situationService.createSituation(situation);
    }

    //R - read operation
    @GetMapping("/situation/readSituation")
    @PreAuthorize("hasAuthority('TEACHER')")
    public List<Situation> readSituation() {
        return situationService.readSituation();
    }

    //U - update operation
    @PutMapping("/situation/updateSituation/{situationId}")
    @PreAuthorize("hasAuthority('TEACHER')")
    public Situation updateSituation(@RequestBody SituationDTO situation, @PathVariable("situationId") Integer situationId) {
        return situationService.updateSituation(situation, situationId);
    }

    //D - delete operation
    @DeleteMapping("/situation/deleteSituation/{situationId}")
    @PreAuthorize("hasAuthority('TEACHER')")
    public String deleteSituation(@PathVariable("situationId") Integer situationId) {
        return situationService.deleteSituation(situationId);
    }
}
