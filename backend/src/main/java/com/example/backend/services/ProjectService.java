package com.example.backend.services;

import com.example.backend.models.Post;
import com.example.backend.models.Project;
import com.example.backend.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAll()
    {
        return projectRepository.findAll();
    }

    public Project getById(Long id)
    {
        Project project = projectRepository.findByIdWithPosts(id).orElse(null);
        if (project != null) {
            project.getPosts().size(); // Explicitly fetch the posts
        }
        return project;
    }

    public Project create(Project project)
    {
        return projectRepository.save(project);
    }

    public Project update(Project project)
    {
        
        Project oldProject = projectRepository.findById(project.getId()).orElse(null);
        oldProject= Project.builder()
            .id(project.getId())
            .name(project.getName())
            .description(project.getDescription())
            .imgUrl(project.getImgUrl())
            .status(project.getStatus())
            .gitUrl(project.getGitUrl())
            .build();
        return projectRepository.save(oldProject);
    }

    public Long delete(Long id)
    {
        projectRepository.deleteById(id);
        return id;
    }

}