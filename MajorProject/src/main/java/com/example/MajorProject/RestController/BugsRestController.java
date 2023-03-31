package com.example.MajorProject.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MajorProject.entity.Bugs;
import com.example.MajorProject.service.BugsService;

@RestController
@RequestMapping("/api")
public class BugsRestController {
    @Autowired
    BugsService bugsService;
    // Get all bugs - Status:working fine
    @GetMapping("/bugs")
    public List<Bugs> findAllBugs()
    {
        return bugsService.findAll();
    }
    // Find bug by id - Status:Working fine
    @GetMapping("/bugs/{bugid}")
    public Bugs findBugById(@PathVariable("bugid") int bugid)
    {
        Bugs bug=bugsService.findById(bugid);
        if(bug==null)
        {
            throw new RuntimeException("The Id::"+bugid+" does not exists in the table");
        }
        return bug;
    }
    //delete bug - Status:Working fine
    @DeleteMapping("/bugs/{bugid}")
    public String deleteBugById(@PathVariable("bugid") int bugid)
    {
        Bugs bug=bugsService.findById(bugid);
        if(bug==null)
        {
            throw new RuntimeException("The Record was not found with the id of "+ bugid);
        }
        bugsService.deleteById(bugid);
        String str="Sucessfully deleted the record with Id "+bugid;
        return str;
    }
    // Add bug - Status: Working fine
    @PostMapping("/bugs")
    public Bugs addBugFun(@RequestBody Bugs bug)
    {
        bug.setBugId(0);
        bugsService.save(bug);
        return bug;
    }
    //Update bug -Status:Working fine
    @PutMapping("/bugs")
    public Bugs updateBugFun(@RequestBody Bugs bug)
    {
        bugsService.save(bug);
        return bug;
    }
    
}
