package com.example.backend.repository;

import com.example.backend.models.Project;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
}