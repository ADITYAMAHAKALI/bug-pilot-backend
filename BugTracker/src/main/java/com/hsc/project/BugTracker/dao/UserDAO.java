package com.hsc.project.BugTracker.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hsc.project.BugTracker.model.User;

@Repository
public interface UserDAO extends CrudRepository<User,Long>{
    User findByUsername(String username);
    User findByEmail(String email);
}
