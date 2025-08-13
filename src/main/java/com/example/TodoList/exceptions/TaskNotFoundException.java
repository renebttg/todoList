package com.example.TodoList.exceptions;


public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String id) {
        super(id);
    }
}
