package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.dto.LoginRequest;
import com.ethioroborobotics.robotics.entity.UserInfo;
import com.ethioroborobotics.robotics.filter.JwtService;
import com.ethioroborobotics.robotics.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    public String login(LoginRequest request) {
        UserInfo user = userInfoRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(user.getUsername());
    }
}
