package com.example.ProductTrialMaster.repository;

import com.example.ProductTrialMaster.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Product entities.
 * Extends JpaRepository to provide CRUD operations and query methods.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
