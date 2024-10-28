package com.jeanpaulpeschard.projecttrackpro.controller;

import com.jeanpaulpeschard.projecttrackpro.dto.TaskDto;
import com.jeanpaulpeschard.projecttrackpro.entity.Task;
import com.jeanpaulpeschard.projecttrackpro.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{projectId}")
    public List<Task> getTasksByProjectId(@PathVariable Long projectId) {
        return taskService.getTasksByProjectId(projectId);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto) {
        Task task = taskService.createTask(taskDto);
        return ResponseEntity.ok(task);
    }
}
