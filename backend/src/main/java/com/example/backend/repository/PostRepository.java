package com.example.backend.repository;

import com.example.backend.models.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    List<Post> findAllByProjectId(Long id);
    
}