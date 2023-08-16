package com.example.demo.entity;

import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
    private int statusCode;
    private String message;
    private T data;

    // Constructors, getters, and setters

    public Result(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public void setMessage(String string) {
        this.message = string;
    }
    public String getMessage() {
        return message;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
    
}
