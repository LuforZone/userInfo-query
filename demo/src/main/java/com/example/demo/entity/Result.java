package com.example.demo.entity;

import org.springframework.http.HttpStatus;

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
}