package com.hsc.project.BugTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsc.project.BugTracker.model.Project;
import com.hsc.project.BugTracker.model.User;
import com.hsc.project.BugTracker.services.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.fetchAllProjects());
    }
    @PostMapping
    public ResponseEntity<Project> saveProject(@RequestBody Project project, @AuthenticationPrincipal User user) {
        if(user.isCredentialsNonExpired()){
            return ResponseEntity.ok(projectService.saveProject(project));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        try {
            if (projectService.fetchProjectById(id).isPresent()) {
                return ResponseEntity.ok(projectService.fetchProjectById(id).get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

}
