package com.voidis.sea_orange_pre.service;

import com.voidis.sea_orange_pre.entity.Task;
import com.voidis.sea_orange_pre.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task createTask(Task task) {
        return this.taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return this.taskRepository.findAll();
    }

    public void deleteTask(Long id) {
        this.taskRepository.deleteById(id);
    }
}
