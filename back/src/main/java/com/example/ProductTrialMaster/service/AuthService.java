package com.example.ProductTrialMaster.service;


import com.example.ProductTrialMaster.dto.AuthRequest;
import com.example.ProductTrialMaster.dto.UserDto;
import com.example.ProductTrialMaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import com.example.ProductTrialMaster.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * AuthService class for handling user authentication and registration.
 * Provides methods to register a new user and authenticate an existing user.
 */

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;


    public String register(UserDto request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email déjà utilisé";
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstname(request.getFirstname());
        user.setUsername(request.getUsername());
        userRepository.save(user);

        return "Compte créé";
    }

    public String authenticate(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        return generateToken(user);
    }

    public String generateToken(User user) {
        Instant now = Instant.now();
        String scope = user.getEmail().equals("admin@admin.com") ? "ADMIN" : "USER";

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(user.getEmail())
                .claim("scope", scope)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}