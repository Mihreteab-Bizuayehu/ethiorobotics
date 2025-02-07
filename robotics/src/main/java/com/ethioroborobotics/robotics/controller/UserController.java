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

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User existingUser = userRepository.findByUsername((user.getUsername()));
        if (existingUser!=null) {

            return ResponseEntity.status(409).body(null);
        }
        User savedUser = userService.register(user);
        return ResponseEntity.status(201).body(savedUser);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody User user) {
        return userService.verify(user);
    }
}


