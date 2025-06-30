package com.example.ProductTrialMaster.controller;

import com.example.ProductTrialMaster.entity.Product;
import com.example.ProductTrialMaster.repository.ProductRepository;
import com.example.ProductTrialMaster.service.ProductService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;


    @PostConstruct
    public void initProducts() {
            List<Product> sampleProducts = Arrays.asList(
                    createSampleProduct("alten-001", "Ordinateur Portable", "PC portable haut de gamme", 999.99, 15),
                    createSampleProduct("alten-002", "Smartphone", "Dernier modèle de smartphone", 699.99, 5),
                    createSampleProduct("alten-003", "Casque Audio", "Casque sans fil avec réduction de bruit", 199.99, 0)
            );

            productRepository.saveAll(sampleProducts);
        }


    private Product createSampleProduct(String code, String name, String description, double price, int quantity) {
        long now = System.currentTimeMillis();
        return Product.builder()
                .code(code)
                .name(name)
                .description(description)
                .price(price)
                .quantity(quantity)
                .category("Electronics")
                .internalReference("REF-" + code)
                .createdAt(now)
                .updatedAt(now)
                .inventoryStatus(quantity > 10 ? Product.InventoryStatus.INSTOCK :
                        quantity > 0 ? Product.InventoryStatus.LOWSTOCK :
                                Product.InventoryStatus.OUTOFSTOCK)
                .rating(5)
                .build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product created = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updated = productService.updateProduct(id, product);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
