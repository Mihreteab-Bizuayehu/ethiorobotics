package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community,Integer> {
}
