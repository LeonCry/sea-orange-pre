package com.voidis.sea_orange_pre.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateTaskParams {
    private Long id;
    @NotBlank(message = "title不能为空")
    private String title;
    private Boolean completed = false;
    private LocalDateTime createTime;
}
