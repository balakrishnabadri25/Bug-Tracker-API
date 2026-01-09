package com.bugtracker.app.repository;

import com.bugtracker.app.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<Bug,Long> {
    List<Bug> findByStatus(String status);
    List<Bug> findByPriority(String priority);
    List<Bug> findByProjectId(Long project_id);
}
