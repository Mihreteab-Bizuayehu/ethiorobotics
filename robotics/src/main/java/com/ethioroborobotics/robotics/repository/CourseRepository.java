package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
