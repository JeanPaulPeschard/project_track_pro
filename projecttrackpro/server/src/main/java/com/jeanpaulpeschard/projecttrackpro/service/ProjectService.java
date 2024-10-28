package com.jeanpaulpeschard.projecttrackpro.service;

import java.util.List;

import com.jeanpaulpeschard.projecttrackpro.dto.ProjectDto;
import com.jeanpaulpeschard.projecttrackpro.entity.Project;

public interface ProjectService {
    List<Project> getAllProjects();
    Project createProject(ProjectDto projectDto);
}
