package com.hsc.project.BugTracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.hsc.project.BugTracker.dao.UserDAO;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // Applies bcrypt strong hashing encryption
    @Autowired
    UserDAO userRepo;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        return username -> {
            // to differentiate between the user created by us ans Spring Security User
            com.hsc.project.BugTracker.model.User user = userRepo.findByUsername(username);
            if (user != null)
                return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.cors().and().csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/bug") .hasAuthority("SCOPE_writebugs")
            .antMatchers(HttpMethod.DELETE, "/api//bug") .hasAuthority("SCOPE_deletebugs")
            .antMatchers(HttpMethod.PUT, "/api/bug").permitAll()
            .antMatchers(HttpMethod.GET, "/api/users").permitAll()
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .and()
            .oauth2ResourceServer(oauth2 -> oauth2.jwt())
            .build();
    }

}
