package com.voidis.sea_orange_pre.service;

import com.voidis.sea_orange_pre.entity.Category;
import com.voidis.sea_orange_pre.entity.Tag;
import com.voidis.sea_orange_pre.entity.Task;
import com.voidis.sea_orange_pre.exception.CustomException;
import com.voidis.sea_orange_pre.repository.CategoryRepository;
import com.voidis.sea_orange_pre.repository.TagRepository;
import com.voidis.sea_orange_pre.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;


    public Task createTask(Task task, Long userId, Long categoryId, List<Long> tagIds) {
        task.setUserId(userId);
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new CustomException(400,"分类不存在"));
        task.setCategory(category);
        List<Tag> tags = this.tagRepository.findAllById(tagIds);
        if(tags.size() != tagIds.size()) {
            throw new CustomException(400,"包含非法或不存在的标签！");
        }
        task.setTags(tags);
        return this.taskRepository.save(task);
    }

    public List<Task> getAllTasks(Long userId) {
        return this.taskRepository.findByUserId(userId);
    }

    public void deleteTask(Long id, Long userId) {
        Task findTask = this.taskRepository.findById(id).orElseThrow(() -> new CustomException(400, "任务不存在!"));
        if (!findTask.getUserId().equals(userId)) {
            throw new CustomException(402, "你没有权限");
        }
        this.taskRepository.deleteById(id);
    }
}
