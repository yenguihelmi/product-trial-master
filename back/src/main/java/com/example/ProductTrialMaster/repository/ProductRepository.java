package com.example.ProductTrialMaster.repository;

import com.example.ProductTrialMaster.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
