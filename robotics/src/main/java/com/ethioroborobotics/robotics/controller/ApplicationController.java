package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Application;
import com.ethioroborobotics.robotics.exception.ResourceNotFoundException;
import com.ethioroborobotics.robotics.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/add")
    public ResponseEntity<Application> createApplication(@RequestBody Application application){
        Application savedApplication=applicationService.createApplication(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedApplication) ;
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications(){
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Application>> getApplicationsByName( @PathVariable("name") String fullName){
        return ResponseEntity.ok(applicationService.getApplicationsByName(fullName));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable("id") Long applicationId, @RequestBody Application application) {
        return applicationService.updateApplication(applicationId, application)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + applicationId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable("id") Long applicationId){
        applicationService.deleteApplication(applicationId);
        return ResponseEntity.noContent().build();
    }


}
