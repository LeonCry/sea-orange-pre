package com.voidis.sea_orange_pre.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateTaskParams {
    private Long id;
    @NotBlank(message = "title不能为空")
    private String title;
    private Boolean completed = false;
    private LocalDateTime createTime;
    @NotNull(message = "必须为任务选择一个分类")
    private Long categoryId;
    private List<Long> tagIds;
}
