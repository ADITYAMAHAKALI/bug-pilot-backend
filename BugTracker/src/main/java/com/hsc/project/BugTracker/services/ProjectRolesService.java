package com.hsc.project.BugTracker.services;

import com.hsc.project.BugTracker.model.ProjectRoles;

import java.util.List;
import java.util.Optional;

public interface ProjectRolesService {
    ProjectRoles saveProjectRole(ProjectRoles projectRoles);
    Optional<ProjectRoles> getProjectRoleById(Long id);
    List<ProjectRoles> getAllProjectRoles();
    ProjectRoles updaProjectRolesById(ProjectRoles projectRoles,Long projectRolesId);
    void deleteProjectRolesById(Long projectRolesId);
}
