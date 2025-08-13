package com.example.TodoList.handlers;

import com.example.TodoList.dto.ApiErrorRecordDTO;
import com.example.TodoList.exceptions.TaskNotFoundException;
import com.example.TodoList.services.ExceptionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    ExceptionService exceptionService;

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ApiErrorRecordDTO> handleTaskNotFound(TaskNotFoundException ex, HttpServletRequest request) {
        String message = "Task not found with id: " + ex.getMessage();
        String path = request.getRequestURI();

        ApiErrorRecordDTO error = exceptionService.createErrorResponse(message, HttpStatus.NOT_FOUND, path);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
