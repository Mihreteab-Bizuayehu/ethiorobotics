package com.ethioroborobotics.robotics.service;

import com.ethioroborobotics.robotics.entity.Post;
import com.ethioroborobotics.robotics.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private PostRepository postRepository;

    public Post addPost(Post post){
        return postRepository.save(post);
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Integer postId){
        return postRepository.findById(postId);
    }

    public Optional<Post> updatePost(Integer postId,Post post){
        return postRepository.findById(postId).map(update->{

            update.setTitle(post.getTitle());
            update.setAuthorName(post.getAuthorName());
            update.setContent(post.getContent());
            update.setCategory(post.getCategory());
            update.setActive(post.isActive());

            return postRepository.save(update);
        });
    }

    public void deletePost(Integer postId){
        postRepository.deleteById(postId);
    }

}
