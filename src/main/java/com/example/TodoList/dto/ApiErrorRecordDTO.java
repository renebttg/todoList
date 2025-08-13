package com.example.TodoList.dto;

import java.time.LocalDateTime;

public record ApiErrorRecordDTO(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {}
