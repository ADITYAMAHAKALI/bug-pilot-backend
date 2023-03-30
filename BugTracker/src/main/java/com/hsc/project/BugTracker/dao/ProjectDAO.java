package com.hsc.project.BugTracker.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hsc.project.BugTracker.model.Project;

@Repository
public interface ProjectDAO extends CrudRepository<Project,Long>{
    List<Project> findByUserUserId(Long userId);
}
