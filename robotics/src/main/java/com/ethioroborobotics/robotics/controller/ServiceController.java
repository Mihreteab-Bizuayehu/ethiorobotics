package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Services;
import com.ethioroborobotics.robotics.service.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceManager serviceManager;

    @PostMapping("/add")
    public ResponseEntity<Services> createService(@RequestBody Services service){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceManager.addService(service));
    }

    @GetMapping
    public ResponseEntity<List<Services>> getAllServices(){
        return ResponseEntity.ok(serviceManager.getAllServices());
    }

    @GetMapping("/service/{id}")
    public ResponseEntity<Optional<Services>> getService(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(serviceManager.getService(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Services>> updateService(@PathVariable("id") Integer id,@RequestBody Services service){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(serviceManager.updateService(id,service));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteService(@PathVariable("id") Integer id){
        serviceManager.deleteService(id);
        return ResponseEntity.ok("Service deleted successfully!");
    }

}
