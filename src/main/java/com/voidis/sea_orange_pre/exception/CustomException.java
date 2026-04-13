package com.voidis.sea_orange_pre.exception;

import lombok.Data;
@Data
public class CustomException extends RuntimeException {
    private Integer code;
    private String message;
    public CustomException(Integer code,String message) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
