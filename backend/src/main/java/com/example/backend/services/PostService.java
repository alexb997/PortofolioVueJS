package com.example.backend.services;

import com.example.backend.models.Post;
import com.example.backend.models.Project;
import com.example.backend.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProjectService projectService;

    public List<Post> getAll()
    {
        return postRepository.findAll();
    }

    public ResponseEntity<List<Post>> getAllByProject(Long id) {
        List<Post> posts = postRepository.findByProjectId(id);
        
        // // Ensure that the Project details are loaded
        // posts.forEach(post -> System.out.println("AICI AI OUTPUT" +post.getProject().getName()));
    
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    public Post getById(Long id)
    {
        return postRepository.findById(id).orElse(null);
    }

    public Post create(Post post)
    {

        System.out.println("post id" + post.getProject().getId());

        return postRepository.save(post);
    }
    
    public Post assignPostToProject(Long postId, Long projectId) {
        Post post = postRepository.findById(postId).orElse(null);
        Project project = projectService.getById(projectId);

        if (post != null && project != null) {
            post.setProject(project);
            return postRepository.save(post);
        }

        return null; // Handle the case where either the post or the project doesn't exist
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