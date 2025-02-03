package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
   Optional<UserInfo> findByUsername(String username);
}
