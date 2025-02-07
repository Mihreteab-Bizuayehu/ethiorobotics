package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
