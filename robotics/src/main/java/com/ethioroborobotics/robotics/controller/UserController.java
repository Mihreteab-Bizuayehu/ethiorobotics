package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.dto.LoginRequest;
import com.ethioroborobotics.robotics.entity.UserInfo;
import com.ethioroborobotics.robotics.repository.UserInfoRepository;
import com.ethioroborobotics.robotics.service.UserInfoDetailService;
import com.ethioroborobotics.robotics.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/register")
    public ResponseEntity<UserInfo> register(@RequestBody UserInfo userInfo) {
        Optional<UserInfo> existingUser = userInfoRepository.findByUsername(userInfo.getUsername());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(409).body(null);
        }

        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        UserInfo savedUser = userInfoRepository.save(userInfo);
        return ResponseEntity.status(201).body(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String token = userInfoService.login(request);
        return ResponseEntity.ok(token);
    }
}


