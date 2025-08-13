package com.example.TodoList.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TaskRecordDTO(
        @NotBlank String title,
        @NotNull(message = "Field 'completed' is required.") Boolean completed) {}
