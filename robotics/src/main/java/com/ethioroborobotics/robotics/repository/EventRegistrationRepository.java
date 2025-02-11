package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRegistrationRepository extends JpaRepository<EventRegistration,Integer > {

    Optional<EventRegistration> findByEmail(String email);
}
