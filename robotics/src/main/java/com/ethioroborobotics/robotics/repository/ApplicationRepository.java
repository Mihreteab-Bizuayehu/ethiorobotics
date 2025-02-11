package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application,Long> {

    List<Application> getApplicationByName(String name);
}
