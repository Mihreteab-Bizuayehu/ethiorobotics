package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
}
