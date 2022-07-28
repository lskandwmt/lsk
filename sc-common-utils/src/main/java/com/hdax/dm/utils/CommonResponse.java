package com.hdax.dm.utils;

import lombok.Data;

@Data
public class CommonResponse<T> {
    private String errorCode = "0000";
    private String message;
    private T data;

    public CommonResponse(T data){
        this.errorCode = "0000";
        this.data = data;
    }

    public CommonResponse(String errorCode, T data){
        this.errorCode = errorCode;
        this.data = data;
    }

    public CommonResponse(String errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }

}
