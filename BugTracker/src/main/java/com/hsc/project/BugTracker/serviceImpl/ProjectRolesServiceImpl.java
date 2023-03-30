package com.hsc.project.BugTracker.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsc.project.BugTracker.dao.ProjectRolesDAO;
import com.hsc.project.BugTracker.model.ProjectRoles;
import com.hsc.project.BugTracker.services.ProjectRolesService;

@Service
public class ProjectRolesServiceImpl implements ProjectRolesService{

    @Autowired
    ProjectRolesDAO projectRolesdao;

    @Override
    public ProjectRoles saveProjectRole(ProjectRoles projectRoles) {
        return projectRolesdao.save(projectRoles);
    }

    @Override
    public Optional<ProjectRoles> getProjectRoleById(Long id) {
       if(projectRolesdao.findById(id).isPresent()){
        return projectRolesdao.findById(id);
       }else{
              throw new RuntimeException("Project Role not found");
       }
    }

    @Override
    public List<ProjectRoles> getAllProjectRoles() {
        return (List<ProjectRoles>) projectRolesdao.findAll();
    }

    @Override
    public ProjectRoles updaProjectRolesById(ProjectRoles projectRoles,Long projectRolesId) {
        if(projectRolesdao.findById(projectRolesId).isPresent()){
            ProjectRoles existingProjectRoles = projectRolesdao.findById(projectRolesId).get();
            existingProjectRoles.setCreator(projectRoles.getCreator());
            existingProjectRoles.setManagers(projectRoles.getManagers());
            return projectRolesdao.save(existingProjectRoles);
        }else{
            throw new RuntimeException("Project Role not found");
        }
    }

    @Override
    public void deleteProjectRolesById(Long projectRolesId) {
        if(projectRolesdao.findById(projectRolesId).isPresent()){
            projectRolesdao.deleteById(projectRolesId);
        }else{
            throw new RuntimeException("Project Role not found");
        }
    }
    
}
