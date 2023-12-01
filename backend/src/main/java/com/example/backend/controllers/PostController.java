package com.example.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Post;
import com.example.backend.services.PostService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/post")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController
{
    @Autowired
    PostService postsService;

    
    @GetMapping("/")
    public ResponseEntity<List<Post>> getAllPosts()
    {
        return ResponseEntity.ok(postsService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post>  getPosts(@PathVariable("id") Long id)
    {
        Post post = postsService.getById(id);
        if (post==null) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id){
        postsService.delete(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Post>  savePost( @RequestBody Post post){
        return ResponseEntity.ok(postsService.create(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        return ResponseEntity.ok(postsService.update(post));
    }
}
