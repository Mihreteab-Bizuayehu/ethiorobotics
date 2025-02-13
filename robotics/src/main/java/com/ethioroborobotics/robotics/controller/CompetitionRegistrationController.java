package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.CompetitionRegistration;
import com.ethioroborobotics.robotics.service.CompetitionRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/competitions")
public class CompetitionRegistrationController {

    private final CompetitionRegistrationService competitionService;


    @PostMapping("/add")
    public ResponseEntity<CompetitionRegistration> createCompetitionRegistration(@RequestBody CompetitionRegistration competition){

        return ResponseEntity.status(HttpStatus.CREATED).body(competitionService.addRegistration(competition));
    }


    @GetMapping
    public ResponseEntity<List<CompetitionRegistration>> getAllCompetitionRegistrations(){

        return ResponseEntity.ok(competitionService.getAllRegistrations());
    }


    @GetMapping("/registration/{id}")
    public  ResponseEntity<Optional<CompetitionRegistration>> getComputationRegistration(@PathVariable("id") Integer id){

        return ResponseEntity.status(HttpStatus.OK).body(competitionService.getRegistration(id));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<CompetitionRegistration>> updateCompetitionRegistration(@PathVariable("id") Integer id, @RequestBody CompetitionRegistration competition){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(competitionService.updateRegistration(id,competition));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompetitionRegistration(@PathVariable Integer id){

        competitionService.deleteCompetition(id);

        return ResponseEntity.ok("Competition registration deleted successfully!");
    }

}
