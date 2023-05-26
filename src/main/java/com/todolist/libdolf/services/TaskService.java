package com.todolist.libdolf.services;

import com.todolist.libdolf.repositories.TaskRepository;
import com.todolist.libdolf.models.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

     public Task createNewTask(Task task){
         return taskRepository.save(task);
     }
     public List<Task> getAllTasks(){
         return taskRepository.findAll();
     }
     public Optional<Task> findById(Long id){
         return taskRepository.findById(id);
     }
     public List<Task> allCompletedTasks(){
         return taskRepository.findByCompletedTrue();
    }
     public List<Task> allIncompleteTasks(){
         return taskRepository.findByCompletedFalse();
     }
     public void deleteTask(Long id){
         taskRepository.deleteById(id);
     }
     public Task updateTask(Task newTask, Long id){
         return taskRepository.findById(id)
                 .map(task -> {
                     task.setTask(newTask.getTask());
                     task.setComplete(newTask.isComplete());
                     return taskRepository.save(task);
                 })
                 .orElseThrow();

     }
}
