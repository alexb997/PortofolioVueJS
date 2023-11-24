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

import com.example.backend.models.Project;
import com.example.backend.services.ProjectService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/project")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController
{
    @Autowired
    ProjectService projectsService;

    @GetMapping("/")
    public ResponseEntity<List<Project>> getAllProjects()
    {
        return ResponseEntity.ok(projectsService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project>  getProjects(@PathVariable("id") Long id)
    {
        Project project = projectsService.getById(id);
        if (project==null) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable("id") Long id){
        projectsService.delete(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Project>  saveProject( @RequestBody Project project){
        return ResponseEntity.ok(projectsService.create(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectsService.update(project));
    }
}
