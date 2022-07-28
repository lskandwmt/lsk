package com.hdax.dm.utils;

public class ResponseUtils<T>{

    public final static<T> CommonResponse<T> returnSuccess(T data){
        return new CommonResponse<>(data);
    }

    public final static<T> CommonResponse<T> returnSuccess(String errorCode, T data){
        return new CommonResponse<>(errorCode, data);
    }

    public final static<T> CommonResponse<T> returnFail(String errorCode, String message){
        return new CommonResponse<>(errorCode, message);
    }

}
