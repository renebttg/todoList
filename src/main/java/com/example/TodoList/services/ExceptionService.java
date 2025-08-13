package com.example.TodoList.services;


import com.example.TodoList.dto.ApiErrorRecordDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExceptionService {

    public ApiErrorRecordDTO createErrorResponse(String message, HttpStatus status, String path) {
        return new ApiErrorRecordDTO(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                path
        );
    }
}
