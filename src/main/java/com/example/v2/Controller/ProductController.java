package com.example.v2.Controller;


import com.example.v2.Model.Product;
import com.example.v2.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product not exist with that id"));
        return ResponseEntity.ok(product);
    }

//    @GetMapping("/products/{category}")
//    public ResponseEntity<Product> getProductsByCategory(@PathVariable String category) {
//      Product product = productRepository.findByCategory(category);
//       return ResponseEntity.ok(product);
//   }


}