package com.voidis.sea_orange_pre.service;

import com.voidis.sea_orange_pre.entity.Task;
import com.voidis.sea_orange_pre.exception.CustomException;
import com.voidis.sea_orange_pre.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task createTask(Task task, Long userId) {
        task.setUserId(userId);
        return this.taskRepository.save(task);
    }

    public List<Task> getAllTasks(Long userId) {
        return this.taskRepository.findByUserId(userId);
    }

    public void deleteTask(Long id, Long userId) {
        Task findTask = this.taskRepository.findById(id).orElseThrow(() -> new CustomException(400,"任务不存在!"));
        if (!findTask.getUserId().equals(userId)) {
            throw new CustomException(402,"你没有权限");
        }
        this.taskRepository.deleteById(id);
    }
}
