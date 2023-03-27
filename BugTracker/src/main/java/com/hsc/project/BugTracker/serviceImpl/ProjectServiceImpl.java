package com.hsc.project.BugTracker.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsc.project.BugTracker.dao.ProjectDAO;
import com.hsc.project.BugTracker.model.Project;
import com.hsc.project.BugTracker.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDAO projectDAO;

    @Override
    public Project saveProject(Project project) {
        return projectDAO.save(project);
    }

    @Override
    public List<Project> fetchAllProjects() {
        return (List<Project>) projectDAO.findAll();
    }

    @Override
    public Optional<Project> fetchProjectById(Long projectId) {
        if (projectDAO.findById(projectId) != null) {
            return projectDAO.findById(projectId);
        } else {
            throw new RuntimeException("Project not found");
        }
    }

    @Override
    public Project updateProject(Project project) {
        try {
            Optional<Project> existingProject = projectDAO.findById(project.getProjectId());
            if (existingProject.isPresent()) {
                Project updatedProject = existingProject.get();
                updatedProject.setProjectName(project.getProjectName());
                updatedProject.setProjectDescription(project.getProjectDescription());
                System.out.println("Project found" + updatedProject);
                return projectDAO.save(updatedProject);
            } else {
                throw new Exception("Project not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteProjectById(Long projectId) {
        if (projectDAO.findById(projectId) != null) {
            projectDAO.deleteById(projectId);
        }else{
            throw new RuntimeException("Project not found");
        }
    }

    @Override
    public Project updateProjectById(Long projectId, Project project) {
        try {
            Optional<Project> existingProject = projectDAO.findById(projectId);
            if (existingProject.isPresent()) {
                Project updatedProject = existingProject.get();
                updatedProject.setProjectName(project.getProjectName());
                updatedProject.setProjectDescription(project.getProjectDescription());
                System.out.println("Project found" + updatedProject);
                return projectDAO.save(updatedProject);
            } else {
                throw new Exception("Project not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
