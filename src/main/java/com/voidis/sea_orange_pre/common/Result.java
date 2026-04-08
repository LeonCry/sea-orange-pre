package com.voidis.sea_orange_pre.common;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //    接口返回成功
    public static <T> Result<T> OK(T data) {
        return new Result<T>(200, "成功.", data);
    }

    //    接口返回失败
    public static <T> Result<T> Err(Integer code, String message) {
        return new Result<T>(code, message, null);
    }
}
