package com.example.MajorProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
     // Adding roles
     @Bean
     public InMemoryUserDetailsManager userDetailsManager(){
         UserDetails hartej=User.builder().username("hartej").password("{noop}123").roles("Employee").build();
         UserDetails aditya=User.builder().username("aditya").password("{noop}123").roles("Manager","Employee").build();
         UserDetails disha=User.builder().username("disha").password("{noop}123").roles("Employee","Manager","Admin").build();
        
         return new InMemoryUserDetailsManager(hartej,aditya,disha);
     }
     
     // Restricting URL based upon roles
     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
     {
         http.authorizeHttpRequests(configurer ->
             configurer
             .antMatchers(HttpMethod.GET,"./api/bugs").hasRole("Employee")
             .antMatchers(HttpMethod.GET,"./api/bugs/**").hasRole("Employee")
             .antMatchers(HttpMethod.POST,"./api/bugs/").hasRole("Manager")
             .antMatchers(HttpMethod.PUT,"./api/bugs/").hasRole("Manager")
             .antMatchers(HttpMethod.DELETE,"./api/bugs/**").hasRole("Admin")
        
         );
         http.httpBasic();
         http.csrf().disable();
         return http.build();
     }
 }
