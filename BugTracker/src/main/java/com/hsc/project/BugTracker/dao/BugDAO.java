package com.hsc.project.BugTracker.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hsc.project.BugTracker.model.Bug;

@Repository
public interface BugDAO extends CrudRepository<Bug,Long>{
    
}
