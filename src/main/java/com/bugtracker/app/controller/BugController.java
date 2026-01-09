package com.bugtracker.app.controller;

import com.bugtracker.app.model.Bug;
import com.bugtracker.app.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BugController {

    @Autowired
    BugService bservice;

    @GetMapping("api/bugs")
    public List<Bug> getAllBugs(){
        return bservice.getAllBugs();
    }

    @GetMapping("api/bugs/{id}")
    public Bug getBug(@PathVariable Long id){
        return bservice.getBug(id);
    }

    @GetMapping("api/bugs/status/{status}")
    public List<Bug> getBugsByStatus(@PathVariable String status){
        return bservice.getBugsByStatus(status);
    }

    @GetMapping("api/bugs/priority/{priority}")
    public List<Bug> getBugsByPriority(@PathVariable String priority){
        return bservice.getBugsByPriority(priority);
    }

    @GetMapping("api/bugs/project/{project_id}")
    public List<Bug> getBugsByProjectId(@PathVariable Long project_id){
        return bservice.getBugsByProjectId(project_id);
    }

    @PostMapping("api/bugs/create")
    public String createBug(@RequestBody Bug bug){
        bservice.createBug(bug);
        return "Bug created successfully";
    }

    @PutMapping("api/bugs/update/{id}")
    public Bug updateBug(@RequestBody Bug bug){
        return bservice.updateBug(bug);
    }

    @PutMapping("api/bugs/{id}/close")
    public String closeBug(@PathVariable Long id){
        bservice.closeBug(id);
        return "bug closed";
    }

    @DeleteMapping("api/bugs/delete/{id}")
    public String deleteBug(@PathVariable Long id){
        bservice.deleteBug(id);
        return "Bug deleted successfully";
    }
}
