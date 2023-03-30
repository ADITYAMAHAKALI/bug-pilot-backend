package com.hsc.project.BugTracker.services;

import java.util.Optional;

import com.hsc.project.BugTracker.model.Project;

import java.util.List;

public interface ProjectService {
    Project saveProject(Project project, Long userId);
    List<Project> fetchAllProjects();
    Optional<Project> fetchProjectById(Long projectId);
    Project updateProject(Project project);
    void deleteProjectById(Long projectId);
    Project updateProjectById(Long projectId, Project project);
    List<Project> fetchAllProjectsByUserId(Long userId);
}
