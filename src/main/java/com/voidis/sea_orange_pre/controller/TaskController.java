package com.voidis.sea_orange_pre.controller;


import com.voidis.sea_orange_pre.common.Result;
import com.voidis.sea_orange_pre.dto.CreateTaskParams;
import com.voidis.sea_orange_pre.dto.TaskDeleteParams;
import com.voidis.sea_orange_pre.entity.Task;
import com.voidis.sea_orange_pre.service.TaskService;
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
    public Result<Task> addTask(@Valid @RequestBody CreateTaskParams taskParams) {
        Task newTask = new Task();
        newTask.setTitle(taskParams.getTitle());
        newTask.setCompleted(taskParams.getCompleted());
        return Result.OK(this.taskService.createTask(newTask));
    }
    @GetMapping("/queryAll")
    public Result<List<Task>> queryAll() {
        return Result.OK(this.taskService.getAllTasks());
    }
    @PostMapping("/deleteById")
    public void deleteById(@RequestBody TaskDeleteParams params) {
        this.taskService.deleteTask(params.getId());
    }
}