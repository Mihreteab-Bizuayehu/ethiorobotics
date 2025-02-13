package com.ethioroborobotics.robotics.service;


import com.ethioroborobotics.robotics.entity.Course;
import com.ethioroborobotics.robotics.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Optional<Course> getCourse(Long id){
        return courseRepository.findById(id);
    }

    public Optional<Course> updateCourse(Long id,Course course){
        return courseRepository.findById(id).map(update->{

            update.setCourseName(course.getCourseName());
            update.setCategory(course.getCategory());
            update.setDuration(course.getDuration());
            update.setDescription(course.getDescription());
            update.setResources(course.getResources());
            update.setPrerequisites(course.getPrerequisites());
            update.setTargetAudience(course.getTargetAudience());

            return courseRepository.save(update);
        });
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

}
