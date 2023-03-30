package com.hsc.project.BugTracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hsc.project.BugTracker.dao.UserDAO;

@Component
public class BugUserDetailsService implements UserDetailsService{

    @Autowired
    private UserDAO userDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByEmail(username)
                .map(BugUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException(()->
                 new UsernameNotFoundException("User not found")));
    }
    
}
