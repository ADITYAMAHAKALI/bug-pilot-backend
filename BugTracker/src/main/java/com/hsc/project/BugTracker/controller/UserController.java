package com.hsc.project.BugTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hsc.project.BugTracker.dao.UserDAO;
import com.hsc.project.BugTracker.model.LoginDetails;
import com.hsc.project.BugTracker.model.User;
import com.nimbusds.jose.shaded.json.JSONObject;

@Controller
// @CrossOrigin(origins="http://localhost:9090")
public class UserController {
    @Autowired
    private UserDAO userRepo;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<String> RegisterUser(@RequestBody User user) {
        try {
            if (userRepo.findByUsername(user.getUsername()) != null) {
                return ResponseEntity.badRequest().body("Username already exists");
            }
            if (userRepo.findByEmail(user.getEmail()) != null) {
                return ResponseEntity.badRequest().body("Email already exists");
            }
            user.setPassword(encoder.encode(user.getPassword()));
            userRepo.save(user);
            return ResponseEntity.ok("User Registered");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occured");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> RegisterUser(@RequestBody LoginDetails user) {
        try {
            if (userRepo.findByEmail(user.getEmail()) == null) {
                return ResponseEntity.badRequest().body("Username doesn't exists");
            } else {
                User user1 = userRepo.findByEmail(user.getEmail());
                if (encoder.matches(user.getPassword(), user1.getPassword())) {
                    JSONObject obj = new JSONObject();
                    obj.put("id" , user1.getUserId());
                    obj.put("message","User Logged in");
                    return ResponseEntity.ok(obj.toString());
                } else {
                    return ResponseEntity.badRequest().body("Password doesn't match");
                }
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occured");
        }
    }

    @GetMapping("/api/users")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        try {
            return ResponseEntity.ok(userRepo.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
