package com.hsc.project.BugTracker.services;

import java.util.List;
import java.util.Optional;

import com.hsc.project.BugTracker.model.Bug;

public interface BugService {
    Bug saveBug(Bug bug,Long projectId);
    List<Bug> fetchAllBugs();
    Optional<Bug> fetchBugById(Long bugId);
    Bug updateBug(Bug bug);
    void deleteBugById(Long bugId);
    Bug updateBugById(Long bugId, Bug bug);
    List<Bug> fetchAllBugsByProjectId(Long projectId);
}
