package com.example.backend.services;

import com.example.backend.models.Post;
import com.example.backend.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAll()
    {
        return postRepository.findAll();
    }

    public Post getById(Long id)
    {
        return postRepository.findById(id).orElse(null);
    }

    public Post create(Post post)
    {
        return postRepository.save(post);
    }

    public Post update(Post post)
    {
        
        Post oldPost = postRepository.findById(post.getId()).orElse(null);
        // oldPost.setDescription(post.getDescription());
        // oldPost.setName(post.getName());
        // oldPost.setImgUrl(post.getImgUrl());
        // oldPost.setStatus(post.getStatus());
        oldPost= Post.builder()
            .id(post.getId())
            .title(post.getTitle())
            .description(post.getDescription())
            .project(post.getProject())
            .build();
        return postRepository.save(oldPost);
    }

    public Long delete(Long id)
    {
        postRepository.deleteById(id);
        return id;
    }

}