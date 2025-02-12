package com.ethioroborobotics.robotics.controller;

import com.ethioroborobotics.robotics.entity.Post;
import com.ethioroborobotics.robotics.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping("/add")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.addPost(post));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable("id") Integer postId){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostById(postId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Post>> updatePost(@PathVariable("id") Integer postId,@RequestBody Post post){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(postService.updatePost(postId,post));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Integer postId){
        postService.deletePost(postId);
        return ResponseEntity.ok("Post deleted successfully!");
    }

}
