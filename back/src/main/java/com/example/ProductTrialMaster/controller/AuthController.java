package com.example.ProductTrialMaster.controller;

import com.example.ProductTrialMaster.dto.AuthRequest;
import com.example.ProductTrialMaster.dto.UserDto;
import com.example.ProductTrialMaster.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    private final AuthService authService;

    /**
     * Endpoint for user registration.
     *
     * @param request the registration request containing user details
     * @return a response entity containing the authentication response
     */

    @PostMapping("/account")
    public ResponseEntity<String> register(@RequestBody UserDto request) {
        return ResponseEntity.ok(authService.register(request));
    }

    /**
     * Endpoint for user authentication.
     *
     * @param request the authentication request containing email and password
     * @return a response entity containing the authentication response
     */
    @PostMapping("/token")
    public ResponseEntity<String> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
