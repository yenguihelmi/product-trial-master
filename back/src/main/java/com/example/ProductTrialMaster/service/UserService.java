package com.example.ProductTrialMaster.service;

import com.example.ProductTrialMaster.entity.User;
import com.example.ProductTrialMaster.exception.ProductNotFoundException;
import com.example.ProductTrialMaster.repository.ProductRepository;
import com.example.ProductTrialMaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * UserService class for managing user operations such as adding/removing products to/from cart and wishlist.
 * Provides methods to manipulate user's cart and wishlist.
 */

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public User addToCart(String email, Long productId) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        user.getCart().add(productId);
        return userRepository.save(user);
    }

    public User removeFromCart(String email, Long productId) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.getCart().remove(productId);
        return userRepository.save(user);
    }

    public User addToWishlist(String email, Long productId) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        user.getWishlist().add(productId);
        return userRepository.save(user);
    }

    public User removeFromWishlist(String email, Long productId) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.getWishlist().remove(productId);
        return userRepository.save(user);
    }

    public Set<Long> getCart(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user.getCart();
    }

    public Set<Long> getWishlist(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user.getWishlist();
    }
}
