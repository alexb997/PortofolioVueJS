package com.example.backend.repository;

import com.example.backend.models.Project;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.posts WHERE p.id = :id")
    Optional<Project> findByIdWithPosts(@Param("id") Long id);
}