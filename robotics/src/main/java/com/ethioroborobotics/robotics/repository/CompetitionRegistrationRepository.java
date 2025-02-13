package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.CompetitionRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRegistrationRepository extends JpaRepository<CompetitionRegistration,Integer> {
}
