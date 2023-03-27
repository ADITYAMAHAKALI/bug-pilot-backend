package com.hsc.project.BugTracker.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsc.project.BugTracker.dao.BugDAO;
import com.hsc.project.BugTracker.model.Bug;
import com.hsc.project.BugTracker.services.BugService;

@Service
public class BugServiceImpl implements BugService {

    @Autowired
    private BugDAO bugDAO;

    @Override
    public Bug saveBug(Bug bug) {
        return bugDAO.save(bug);
    }

    @Override
    public List<Bug> fetchAllBugs() {
        return (List<Bug>) bugDAO.findAll();
    }

    @Override
    public Optional<Bug> fetchBugById(Long bugId) {
        return bugDAO.findById(bugId);
    }

    @Override
    public Bug updateBug(Bug bug) {
        try {
            Optional<Bug> existingBug = bugDAO.findById(bug.getBugId());
            if (existingBug.isPresent()) {
                Bug updatedBug = existingBug.get();
                updatedBug.setBugTitle(bug.getBugTitle());
                updatedBug.setBugAuthor(bug.getBugAuthor());
                updatedBug.setBugLabel(bug.getBugLabel());
                updatedBug.setOpen(bug.isOpen());
                System.out.println("Bug found" + updatedBug);
                return bugDAO.save(updatedBug);
            } else {
                throw new Exception("Bug not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteBugById(Long bugId) {
        try {
            if (bugDAO.findById(bugId).isPresent()) {
                bugDAO.deleteById(bugId);
            } else {
                throw new Exception("Bug not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bug updateBugById(Long bugId, Bug bug) {
        try {
            if (bugDAO.findById(bugId).isPresent()) {
                Bug new_bug = this.fetchBugById(bugId).get();
                new_bug.setBugTitle(bug.getBugTitle());
                new_bug.setBugAuthor(bug.getBugAuthor());
                new_bug.setBugLabel(bug.getBugLabel());
                new_bug.setOpen(bug.isOpen());
                return bugDAO.save(new_bug);
            } else {
                throw new Exception("Bug not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Bug> fetchAllBugsByProjectId(Long projectId) {
        return bugDAO.findByProjectProjectId(projectId);
        
    }

}