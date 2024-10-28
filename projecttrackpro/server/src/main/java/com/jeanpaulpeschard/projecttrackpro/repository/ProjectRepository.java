package com.jeanpaulpeschard.projecttrackpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeanpaulpeschard.projecttrackpro.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}