package com.jeanpaulpeschard.projecttrackpro.service.impl;

import com.jeanpaulpeschard.projecttrackpro.dto.ProjectDto;
import com.jeanpaulpeschard.projecttrackpro.entity.Project;
import com.jeanpaulpeschard.projecttrackpro.repository.ProjectRepository;
import com.jeanpaulpeschard.projecttrackpro.service.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProjectServiceImplTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProject() {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName("Test Project");
        projectDto.setDescription("Description for Test Project");

        Project project = new Project();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());

        when(projectRepository.save(project)).thenReturn(project);

        Project createdProject = projectService.createProject(projectDto);

        assertEquals("Test Project", createdProject.getName());
        assertEquals("Description for Test Project", createdProject.getDescription());
    }

    @Test
    public void testGetAllProjects() {
        Project project1 = new Project();
        project1.setName("Project 1");

        Project project2 = new Project();
        project2.setName("Project 2");

        List<Project> projects = Arrays.asList(project1, project2);

        when(projectRepository.findAll()).thenReturn(projects);

        List<Project> retrievedProjects = projectService.getAllProjects();

        assertEquals(2, retrievedProjects.size());
        assertEquals("Project 1", retrievedProjects.get(0).getName());
    }
}
