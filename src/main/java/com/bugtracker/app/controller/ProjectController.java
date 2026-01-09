package com.bugtracker.app.controller;

import com.bugtracker.app.model.Project;
import com.bugtracker.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectService pservice;

    @GetMapping("/api/projects")
    public List<Project> getAllProjects(){
        return pservice.getAllProjects();
    }

    @GetMapping("/api/projects/{id}")
    public Project getProject(@PathVariable Long id){
        return pservice.getProject(id);
    }

    @PostMapping("/api/projects/create")
    public String createProject(@RequestBody Project project){
        pservice.createProject(project);
        return project.getName()+" project created successfully";
    }

    @PutMapping("api/projects/update/{id}")
    public Project updateProject(@PathVariable Long id,@RequestBody Project projectDetails){
        return pservice.updateProject(id,projectDetails);
    }

    @DeleteMapping("api/projects/delete/{id}")
    public String deleteProject(@PathVariable Long id){
        Project existP = pservice.deleteProject(id);
        return "Project "+existP.getName()+" deleted successfully";
    }
}
