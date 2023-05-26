package com.todolist.libdolf.controllers;

import com.todolist.libdolf.services.TaskService;
import com.todolist.libdolf.models.Task;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {

    TaskService taskService;
    @GetMapping(value = "/")
    public ResponseEntity<List<Task>> getAll(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @GetMapping(value = "/complete")
    public ResponseEntity<List<Task>> getAllCompleteTask(){
        return ResponseEntity.ok(taskService.allCompletedTasks());
    }
    @GetMapping(value = "/incomplete")
    public ResponseEntity<List<Task>> getAllIncompleteTask(){
        return ResponseEntity.ok(taskService.allIncompleteTasks());
    }
    @PostMapping(value = "/")
    public ResponseEntity<Task> createNewTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createNewTask(task));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTask(task,id));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }
}
