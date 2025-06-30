package com.example.ProductTrialMaster.controller;

import com.example.ProductTrialMaster.dto.ProductDto;
import com.example.ProductTrialMaster.entity.Product;
import com.example.ProductTrialMaster.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    /**
     * Endpoint to retrieve all products.
     *
     * @return a list of all products
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    /**
     * Endpoint to retrieve a product by its ID.
     *
     * @param id the ID of the product
     * @return the product with the specified ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    /**
     * Endpoint to create a new product.
     *
     * @param productDto the product data transfer object containing product details
     * @return the created product
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDto));
    }
    /**
     * Endpoint to update an existing product.
     *
     * @param id the ID of the product to update
     * @param productDto the product data transfer object containing updated product details
     * @return the updated product
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }
    /**
     * Endpoint to delete a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return a response entity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
