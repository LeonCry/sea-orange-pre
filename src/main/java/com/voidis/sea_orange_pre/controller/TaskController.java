package com.voidis.sea_orange_pre.controller;

import com.voidis.sea_orange_pre.common.Result;
import com.voidis.sea_orange_pre.dto.CreateTaskParams;
import com.voidis.sea_orange_pre.dto.TaskDeleteParams;
import com.voidis.sea_orange_pre.entity.Task;
import com.voidis.sea_orange_pre.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public Result<Task> addTask(@Valid @RequestBody CreateTaskParams taskParams, HttpServletRequest httpRequest) {
        Long userId = (Long) httpRequest.getAttribute("userId");
        Task newTask = new Task();
        newTask.setTitle(taskParams.getTitle());
        newTask.setCompleted(taskParams.getCompleted());
        Long categoryId = taskParams.getCategoryId();
        List<Long> tagIds = taskParams.getTagIds();
        return Result.OK(this.taskService.createTask(newTask, userId,categoryId,tagIds));
    }

    @GetMapping("/queryAll")
    public Result<List<Task>> queryAll(HttpServletRequest httpRequest) {
        Long userId = (Long) httpRequest.getAttribute("userId");
        return Result.OK(this.taskService.getAllTasks(userId));
    }

    @PostMapping("/deleteById")
    public void deleteById(@RequestBody TaskDeleteParams params, HttpServletRequest httpRequest) {
        Long userId = (Long) httpRequest.getAttribute("userId");
        this.taskService.deleteTask(params.getId(), userId);
    }
}