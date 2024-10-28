package com.jeanpaulpeschard.projecttrackpro.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanpaulpeschard.projecttrackpro.dto.TaskDto;
import com.jeanpaulpeschard.projecttrackpro.entity.Task;
import com.jeanpaulpeschard.projecttrackpro.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    // Create a new task
    public TaskDto createTask(TaskDto taskDto) {
        Task task = modelMapper.map(taskDto, Task.class);
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask, TaskDto.class);
    }

    // Retrieve a task by ID
    public Optional<TaskDto> getTaskById(Long id) {
        return taskRepository.findById(id).map(task -> modelMapper.map(task, TaskDto.class));
    }

    // Retrieve all tasks
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .toList();
    }

    // Update a task
    public Optional<TaskDto> updateTask(Long id, TaskDto taskDto) {
        return taskRepository.findById(id).map(existingTask -> {
            existingTask.setTitle(taskDto.getTitle());
            existingTask.setDescription(taskDto.getDescription());
            existingTask.setStatus(taskDto.getStatus());
            existingTask.setDueDate(taskDto.getDueDate());
            Task updatedTask = taskRepository.save(existingTask);
            return modelMapper.map(updatedTask, TaskDto.class);
        });
    }

    // Delete a task
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Retrieve tasks by project ID
    public List<TaskDto> getTasksByProjectId(Long projectId) {
        return taskRepository.findByProjectId(projectId).stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .toList();
    }
}
