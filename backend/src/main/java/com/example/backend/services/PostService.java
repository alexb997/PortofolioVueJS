package com.example.backend.services;

import com.example.backend.models.Post;
import com.example.backend.models.Project;
import com.example.backend.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProjectService projectService;

    public Page<Post> getAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public ResponseEntity<List<Post>> getAllByProject(Long id) {
        List<Post> posts = postRepository.findByProjectId(id);

        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    public Post create(Post post)
    {

        System.out.println("post id" + post.getProject().getId());

        return postRepository.save(post);
    }
    //Might change return type to boolean, true if succeeds, false if doesnt and exception handling for inexistent post/project
    public Post assignPostToProject(Long postId, Long projectId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        Optional<Project> optionalProject = projectService.getById(projectId);
        if (optionalPost.isPresent() && optionalProject.isPresent()) {
            Project project = optionalProject.get();
            Post post = optionalPost.get();
            post.setProject(project);
            return postRepository.save(post);
        }
        return null;
    }

    public Post update(Post post)
    {
        
        Post oldPost = postRepository.findById(post.getId()).orElse(null);
        oldPost= Post.builder()
            .id(post.getId())
            .title(post.getTitle())
            .description(post.getDescription())
            .reference(post.getReference())
            .type(post.getType())
            .build();
        return postRepository.save(oldPost);
    }

    public Long delete(Long id)
    {
        postRepository.deleteById(id);
        return id;
    }

}