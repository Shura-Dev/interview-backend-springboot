package com.industriascin.interview.controllers;

import com.industriascin.interview.models.TaskEntity;
import com.industriascin.interview.services.TaskService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

  @Autowired
  TaskService taskService;

  @GetMapping
  public ResponseEntity<List<TaskEntity>> getAllTasks() {
    return ResponseEntity.ok().body(taskService.getAllTasks());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<TaskEntity>> getTaskById(@PathVariable UUID id) {
    return ResponseEntity.ok().body(taskService.getTaskById(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TaskEntity saveTask (@RequestBody TaskEntity task) {
    return taskService.saveTask(task);
  }

  @DeleteMapping("/{id}")
  public void deleteTaskById(@PathVariable UUID id) {
    taskService.deleteTaskById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TaskEntity> updateTask(@PathVariable UUID id, @RequestBody TaskEntity task) {
    TaskEntity taskUpdated =taskService.updateTask(id, task);
    return new ResponseEntity<>(taskUpdated, HttpStatus.OK);
  }
}
