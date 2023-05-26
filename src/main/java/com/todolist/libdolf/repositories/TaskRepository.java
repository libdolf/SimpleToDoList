package com.todolist.libdolf.repositories;

import com.todolist.libdolf.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT e FROM Task e WHERE e.complete = true")
    List<Task> findByCompletedTrue();

    @Query(value = "SELECT t FROM Task t WHERE t.complete = false")
    public List<Task> findByCompletedFalse();
}
