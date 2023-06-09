package com.hsc.project.BugTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsc.project.BugTracker.model.Bug;
import com.hsc.project.BugTracker.services.BugService;

// @CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/{project_id}/bug")
public class BugContoller {

    @Autowired
    private BugService bugService;

    @GetMapping("/{id}")
    public ResponseEntity<Bug> getBugById(@PathVariable Long id){
        try{
            if(bugService.fetchBugById(id).isPresent()){
                return ResponseEntity.ok(bugService.fetchBugById(id).get());
            }
            else{
                throw new Exception("Bug not found");
            }
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Bug>> getAllBugs(@PathVariable Long project_id){
        try{
            return ResponseEntity.ok(bugService.fetchAllBugsByProjectId(project_id));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Bug> saveBug(@RequestBody Bug bug,@PathVariable Long project_id){
        try{
            return ResponseEntity.ok(bugService.saveBug(bug,project_id));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Bug> updateBug(@RequestBody Bug bug,@PathVariable Long id){
        try{
            return ResponseEntity.ok(bugService.updateBugById(id,bug));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBug(@PathVariable Long id){
        try{
            bugService.deleteBugById(id);
            return ResponseEntity.ok("Bug deleted");
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
    
}
