package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.UserInfo;
import com.ethioroborobotics.robotics.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserInfoDetailService implements UserDetailsService {

    private final UserInfoRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();
        }
        throw new UsernameNotFoundException(username);
    }

    private String[] getRoles(UserInfo userInfo) {
        if (userInfo.getRole() == null || userInfo.getRole().isEmpty()) {
            return new String[]{"USER"};
        }
        return userInfo.getRole().split(",");
    }
}
