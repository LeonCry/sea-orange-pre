package com.voidis.sea_orange_pre.exception;

import com.voidis.sea_orange_pre.common.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Void> handleValidationException(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        return Result.Err(400, errorMessage);
    }

    @ExceptionHandler(CustomException.class)
    public Result<Void> handleCustomException(CustomException e) {
        return Result.Err(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<Void> handleFinalException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        return Result.Err(500, "内部服务器错误");
    }
}
