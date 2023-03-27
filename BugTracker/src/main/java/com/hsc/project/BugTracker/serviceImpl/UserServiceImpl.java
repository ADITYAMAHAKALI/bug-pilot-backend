package com.hsc.project.BugTracker.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsc.project.BugTracker.dao.UserDAO;
import com.hsc.project.BugTracker.model.User;
import com.hsc.project.BugTracker.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public User saveUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        return (List<User>) userDAO.findAll();
    }

    @Override
    public Optional<User> fetchUserById(Long userId) {
        if(userDAO.findById(userId)!=null){
            return userDAO.findById(userId);
        }else{
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public User updateUserById(Long userId, User user) {
        if(userDAO.findById(userId)!=null){
            User existingUser = userDAO.findById(userId).get();
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
            return userDAO.save(existingUser);
        }else{
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void deleteUserById(Long userId) {
        if(userDAO.findById(userId)!=null){
            userDAO.deleteById(userId);
        }else{
            throw new RuntimeException("User not found");
        }
    }
    
}
