package com.example.ProductTrialMaster.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "alten_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstname;
    private String email;
    private String password;

    @ElementCollection
    @CollectionTable(name = "user_cart", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "product_id")
    private Set<Long> cart = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "user_wishlist", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "product_id")
    private Set<Long> wishlist = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Role role;
}

