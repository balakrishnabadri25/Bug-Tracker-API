package com.bugtracker.app.service;

import com.bugtracker.app.model.Bug;
import com.bugtracker.app.repository.BugRepository;
import com.bugtracker.app.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugService {

    @Autowired
    BugRepository brepo;

    @Autowired
    ProjectRepository prepo;

    public List<Bug> getAllBugs() {
        return brepo.findAll();
    }

    public Bug getBug(Long id) {
        return brepo.findById(id).orElseThrow(()->new RuntimeException("Bug not found"));
    }

    public void createBug(Bug bug) {
        Long project_id = bug.getProject().getId();
        prepo.findById(project_id).orElseThrow(()->new RuntimeException("Project deos not exist"));
        brepo.save(bug);
    }

    public List<Bug> getBugsByStatus(String status) {
        return brepo.findByStatus(status);
    }

    public List<Bug> getBugsByPriority(String priority) {
        return brepo.findByPriority(priority);
    }

    public List<Bug> getBugsByProjectId(Long projectId) {
        return brepo.findByProjectId(projectId);
    }

    public Bug updateBug(Bug bug) {
        Bug existB = brepo.findById(bug.getId()).orElseThrow(()->new RuntimeException("Bug not found"));
        Long project_id = bug.getProject().getId();
        if(!prepo.existsById(project_id)) throw new RuntimeException("Project does not exist");
        existB.setDescription(bug.getDescription());
        existB.setPriority(bug.getPriority());
        existB.setTitle(bug.getTitle());
        existB.setStatus(bug.getStatus());
        existB.setProject(bug.getProject());
        return brepo.save(existB);
    }

    public void deleteBug(Long id) {
        if(!brepo.existsById(id)) throw new RuntimeException("Bug not found");
        brepo.deleteById(id);
    }

    public void closeBug(Long id) {
        Bug bug = brepo.findById(id).orElseThrow(()->new RuntimeException("bug not found"));
        bug.setStatus("CLOSED");
        brepo.save(bug);
    }
}
