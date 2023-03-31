package com.hsc.project.BugTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsc.project.BugTracker.dao.UserDAO;
import com.hsc.project.BugTracker.model.Project;
import com.hsc.project.BugTracker.services.ProjectRolesService;
import com.hsc.project.BugTracker.services.ProjectService;

@RestController
@RequestMapping("/api/{user_id}/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectRolesService projectRolesService;
    
    @Autowired
    UserDAO userRepo;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(@PathVariable("user_id") Long userId) {
        
        return ResponseEntity.ok(projectService.fetchAllProjectsByUserId(userId));
    }
   
    @PostMapping
    public ResponseEntity<Project> saveProject(@RequestBody Project project,@PathVariable("user_id") Long userId) {
            Project new_project = projectService.saveProject(project,userId);
            return ResponseEntity.ok(new_project);
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
   
    @PutMapping("/{id}") // this id is my project id
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        try {
            if (projectService.fetchProjectById(id).isPresent()) {
                Project new_project = projectService.fetchProjectById(id).get();
                new_project.setProjectName(project.getProjectName());
                new_project.setProjectDescription(project.getProjectDescription());
                return ResponseEntity.ok(projectService.updateProject(new_project));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        try {
            if (projectService.fetchProjectById(id).isPresent()) {
                projectService.deleteProjectById(id); 
                return ResponseEntity.ok("Project deleted");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

}
