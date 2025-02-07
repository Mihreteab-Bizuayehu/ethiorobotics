package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
