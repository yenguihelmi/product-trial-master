package com.example.ProductTrialMaster.controller;


import com.example.ProductTrialMaster.entity.User;
import com.example.ProductTrialMaster.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/cart")
    public ResponseEntity<Set<Long>> getCart(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(userService.getCart(userDetails.getUsername()));
    }

    @PostMapping("/cart/add/{productId}")
    public ResponseEntity<User> addToCart(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long productId) {
        return ResponseEntity.ok(userService.addToCart(userDetails.getUsername(), productId));
    }

    @DeleteMapping("/cart/remove/{productId}")
    public ResponseEntity<User> removeFromCart(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long productId) {
        return ResponseEntity.ok(userService.removeFromCart(userDetails.getUsername(), productId));
    }

    @GetMapping("/wishlist")
    public ResponseEntity<Set<Long>> getWishlist(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(userService.getWishlist(userDetails.getUsername()));
    }

    @PostMapping("/wishlist/add/{productId}")
    public ResponseEntity<User> addToWishlist(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long productId) {
        return ResponseEntity.ok(userService.addToWishlist(userDetails.getUsername(), productId));
    }

    @DeleteMapping("/wishlist/remove/{productId}")
    public ResponseEntity<User> removeFromWishlist(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long productId) {
        return ResponseEntity.ok(userService.removeFromWishlist(userDetails.getUsername(), productId));
    }
}
