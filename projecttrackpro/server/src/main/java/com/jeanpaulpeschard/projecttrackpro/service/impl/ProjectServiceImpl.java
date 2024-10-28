package com.jeanpaulpeschard.projecttrackpro.service.impl;

import com.jeanpaulpeschard.projecttrackpro.entity.Project;
import com.jeanpaulpeschard.projecttrackpro.dto.ProjectDto;
import com.jeanpaulpeschard.projecttrackpro.repository.ProjectRepository;
import com.jeanpaulpeschard.projecttrackpro.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project createProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        return projectRepository.save(project);
    }
}
