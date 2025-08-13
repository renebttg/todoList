package com.example.TodoList.controllers;

import com.example.TodoList.dto.TaskRecordDTO;
import com.example.TodoList.models.TaskModel;
import com.example.TodoList.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskModel> insertTask(@RequestBody @Valid TaskRecordDTO taskRecordDTO) {
        return taskService.insertTask(taskRecordDTO);
    }

    @GetMapping
    public  ResponseEntity<Object> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTask(@PathVariable Long id) {
        return taskService.getOneTask(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTaskCompleted(@PathVariable Long id, @RequestBody @Valid TaskRecordDTO dto) {
        return taskService.updateTaskCompleted(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") Long id) {
        return taskService.deleteTask(id);
    }

}
