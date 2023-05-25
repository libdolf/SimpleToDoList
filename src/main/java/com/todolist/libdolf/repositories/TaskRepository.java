package com.todolist.libdolf.repositories;

import com.todolist.libdolf.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    //public List<Task> findByCompletedTrue();
    //public List<Task> findByCompletedFalse();
}
