package com.bugtracker.app.service;

import com.bugtracker.app.model.Project;
import com.bugtracker.app.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository prepo;

    public List<Project> getAllProjects() {
        return prepo.findAll();
    }

    public void createProject(Project project) {
        prepo.save(project);
    }

    public Project updateProject(Long id,Project projectDetails) {
        Project existP = prepo.findById(id).orElseThrow(()->new RuntimeException("Project not found"));
        existP.setName(projectDetails.getName());
        existP.setDescription(projectDetails.getDescription());
        prepo.save(existP);
        return existP;
    }

    public Project getProject(Long id) {
        return prepo.findById(id).orElseThrow(()->new RuntimeException("Project not found"));
    }

    public Project deleteProject(Long id) {
        Project existP = prepo.findById(id).orElseThrow(()->new RuntimeException("Project not found to delete"));
        prepo.deleteById(id);
        return existP;
    }
}
