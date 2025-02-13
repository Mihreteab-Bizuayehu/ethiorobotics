package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Course;
import com.ethioroborobotics.robotics.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(course));
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Optional<Course>> getCourse(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getCourse(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Course>> updateCourse(@PathVariable("id") Long id,@RequestBody Course course){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(courseService.updateCourse(id,course));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course is successfully deleted!");
    }

}
