package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
