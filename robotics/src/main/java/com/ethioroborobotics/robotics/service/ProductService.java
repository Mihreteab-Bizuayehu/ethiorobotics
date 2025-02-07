package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.Product;
import com.ethioroborobotics.robotics.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ProductService {

   private final ProductRepository productRepository;

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long productId){
        return productRepository.findById(productId);
    }

    public Optional<Product>updateProduct(Long productId,Product updateProduct){
       return productRepository.findById(productId).map(product -> {

           product.setProductName(updateProduct.getProductName());
           product.setProductCategory(updateProduct.getProductCategory());
           product.setProductPrice(updateProduct.getProductPrice());
           product.setProductDescription(updateProduct.getProductDescription());
           product.setProductInStock(updateProduct.getProductInStock());
           product.setDateAdded(updateProduct.getDateAdded());
           product.setIsActive(updateProduct.getIsActive());

           return productRepository.save(updateProduct);
       });
    }

    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }
}
