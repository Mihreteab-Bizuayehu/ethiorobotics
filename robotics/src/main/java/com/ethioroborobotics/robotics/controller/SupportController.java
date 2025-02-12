package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Support;
import com.ethioroborobotics.robotics.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/supports")
public class SupportController {

    private final SupportService supportService;

    @PostMapping("/add")
    public ResponseEntity<Support> createSupport(@RequestBody Support support){
        return ResponseEntity.status(HttpStatus.CREATED).body(supportService.addSupport(support));
    }

    @GetMapping
    public ResponseEntity<List<Support>> getAllSupports(){
        return ResponseEntity.ok(supportService.getAllSupports());
    }

    @GetMapping("/support/{id}")
    public ResponseEntity<Optional<Support>> getSupportById(@PathVariable("id") Integer supportId){
        return ResponseEntity.status(HttpStatus.OK).body(supportService.getSupportById(supportId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Support>> updateSupport(@PathVariable("id") Integer supportId,@RequestBody Support support){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(supportService.updateSupport(supportId,support));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSupport(@PathVariable("id") Integer supportId){
        supportService.deleteSupport(supportId);
        return ResponseEntity.ok("Support deleted successfully!");
    }

}
