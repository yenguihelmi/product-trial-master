package com.example.ProductTrialMaster.repository;

import com.example.ProductTrialMaster.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * UserRepository interface for managing user entities.
 * Provides methods to find users by email.
 */

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
