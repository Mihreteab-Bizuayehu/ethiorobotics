package com.ethioroborobotics.robotics.repository;

import com.ethioroborobotics.robotics.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
