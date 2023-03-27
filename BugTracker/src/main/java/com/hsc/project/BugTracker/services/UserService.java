package com.hsc.project.BugTracker.services;

import java.util.List;
import java.util.Optional;

import com.hsc.project.BugTracker.model.User;

public interface UserService {
    User saveUser(User user);
    List<User> fetchAllUsers();
    Optional<User> fetchUserById(Long userId);
    User updateUserById(Long userId, User user);
    void deleteUserById(Long userId);
}
