package com.ethioroborobotics.robotics.controller;
import com.ethioroborobotics.robotics.entity.User;
import com.ethioroborobotics.robotics.repository.UserRepository;
import com.ethioroborobotics.robotics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;


    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (user.getUsername() == null || userRepository.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(409).body("Username already exists or invalid input");
        }
        User savedUser = userService.register(user);
        return ResponseEntity.status(201).body(savedUser);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String token = userService.verify(user);
        return ResponseEntity.ok(token);
    }
}


