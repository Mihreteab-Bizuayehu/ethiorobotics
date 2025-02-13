package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Services,Integer> {
}
