package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Community;
import com.ethioroborobotics.robotics.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/communities")
public class CommunityController {

    private final CommunityService communityService;

    @PostMapping("/add")
    public ResponseEntity<Community> addCommunityService(@RequestBody Community community){
        Community saved=communityService.addCommunityService(community);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Community>> getAllCommunityService(){
        return ResponseEntity.ok(communityService.getAllCommunityService());
    }

    @GetMapping("community/{id}")
    public ResponseEntity<Optional<Community>> getCommunityService(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(communityService.getCommunityService(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Community>> updateCommunityService(@PathVariable("id") Integer id,@RequestBody Community community){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(communityService.updateCommunityService(id,community));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCommunityService(@PathVariable("id") Integer id){
      communityService.deleteCommunityService(id);

      return ResponseEntity.ok("Service deleted successfully!");
    }

}
