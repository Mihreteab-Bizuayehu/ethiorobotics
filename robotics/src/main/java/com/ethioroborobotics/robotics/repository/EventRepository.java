package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {
}
