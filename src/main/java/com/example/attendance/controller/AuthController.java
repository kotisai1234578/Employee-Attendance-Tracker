package com.example.attendance.controller;

import com.example.attendance.dto.LoginRequest;
import com.example.attendance.entity.Employee; // Assuming this is your user entity
import com.example.attendance.security.JwtService;
import com.example.attendance.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
        return ResponseEntity.ok(jwtService.generateToken(user));
    }

    // Register endpoint to create a new user
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Employee employee) {
        boolean userExists = userDetailsService.userExists(employee.getUsername());
        if (userExists) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        userDetailsService.saveUser(employee);
        return ResponseEntity.ok("User registered successfully");
    }
}
