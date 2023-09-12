package com.industriascin.interview.services;

import com.industriascin.interview.models.TaskEntity;
import com.industriascin.interview.repositories.TaskRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
  @Autowired
  TaskRepository taskRepository;

  public List<TaskEntity> getAllTasks() {
    return taskRepository.findAll();
  }

  public Optional<TaskEntity> getTaskById(UUID id) {
    return taskRepository.findById(id);
  }

  public TaskEntity saveTask(TaskEntity task) {
    return taskRepository.save(task);
  }

  public void deleteTaskById(UUID id) {
    taskRepository.deleteById(id);
  }

  public TaskEntity updateTask(UUID id, TaskEntity task) {
    Optional<TaskEntity>  oldTask = taskRepository.findById(id);

    TaskEntity newTask = oldTask.get();
    newTask.setTitle(task.getTitle());
    newTask.setDescription(task.getDescription());
    newTask.setCompleted(task.isCompleted());

    return newTask;
  }
}
