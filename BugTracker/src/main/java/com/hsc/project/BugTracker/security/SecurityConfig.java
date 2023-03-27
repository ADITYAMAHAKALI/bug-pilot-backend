package com.hsc.project.BugTracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.hsc.project.BugTracker.dao.UserDAO;

@Configuration
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
        return http
                .authorizeRequests()
                .antMatchers("/", "/**").permitAll()
                .and()
                .csrf()
                .ignoringAntMatchers("/", "/**","/api/**")
                .and()
                // .formLogin()
                // .loginPage("/login")
                // .permitAll()
                // .and()
                .build();
    }

}
