package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Product;
import com.ethioroborobotics.robotics.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

   private final ProductService productService;

@PostMapping("/add")
    public ResponseEntity<Product> AddProduct(@RequestBody Product product){

    Product createdProduct=productService.addProduct(product);

    return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
}

@GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){

    List<Product> products=productService.getAllProduct();

    return ResponseEntity.status(HttpStatus.OK).body(products);
}

@PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId,@RequestBody Product product){

    Optional<Product> updatedProduct=productService.updateProduct(productId,product);

    return updatedProduct
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
}

@DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){

    productService.deleteProduct(productId);

}
}
