package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.Product;
import com.ethioroborobotics.robotics.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByProductName(String productName);

    List<Product> findByProductCategory(ProductCategory productCategory);
}
