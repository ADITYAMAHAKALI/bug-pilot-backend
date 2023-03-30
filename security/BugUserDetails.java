package com.hsc.project.BugTracker.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hsc.project.BugTracker.model.User;

import lombok.Data;

@Data
public class BugUserDetails implements UserDetails{

    private String username;
    private String password;

    private List<GrantedAuthority> authorities;

    public BugUserDetails(User user) {
        username=user.getEmail();
        password=user.getPassword();
        authorities=Arrays.stream(user.getRoles()
                        .split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
        
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
      return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    
}
