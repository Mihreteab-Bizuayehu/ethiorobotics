package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.CustomUserDetails;
import com.ethioroborobotics.robotics.entity.User;
import com.ethioroborobotics.robotics.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(Objects.isNull(user)) {

            throw new UsernameNotFoundException("User not found");
        }

        return new  CustomUserDetails(user);
    }

    private String[] getRoles(User user) {

        if (user.getRole() == null) {
            return new String[]{"USER"};
        }

        return new String[]{user.getRole().name()};
    }
}
