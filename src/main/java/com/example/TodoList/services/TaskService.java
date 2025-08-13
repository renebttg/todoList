package com.example.TodoList.services;

import com.example.TodoList.dto.TaskRecordDTO;
import com.example.TodoList.exceptions.TaskNotFoundException;
import com.example.TodoList.models.TaskModel;
import com.example.TodoList.repositories.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public ResponseEntity<TaskModel> insertTask(@RequestBody @Valid TaskRecordDTO taskRecordDTO) {
        TaskModel taskModel = new TaskModel();
        BeanUtils.copyProperties(taskRecordDTO, taskModel);

        taskModel.setTime(LocalDateTime.now());

        TaskModel saved = taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    public  ResponseEntity<Object> getAllTasks() {
        List<TaskModel> allTasks = taskRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allTasks);
    }

    public ResponseEntity<Object> getOneTask(@PathVariable Long id) {
        TaskModel task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with " + id + " Not Found"));
        return ResponseEntity.ok(task);

    }

    public ResponseEntity<Object> updateTaskCompleted(@PathVariable Long id, @RequestBody @Valid TaskRecordDTO dto) {
        TaskModel updatedTask = taskRepository.findById(id)
                .map(task -> {
                    task.setCompleted(dto.completed());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new TaskNotFoundException("Task With " + id + " Not Found"));

        return ResponseEntity.ok(updatedTask);

    }

    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") Long id) {
        TaskModel deletedTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with " + id + " Not Found"));

        taskRepository.delete(deletedTask);

        return ResponseEntity.noContent().build();

    }


}
