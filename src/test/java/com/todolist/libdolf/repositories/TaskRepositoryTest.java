package com.todolist.libdolf.repositories;

import com.todolist.libdolf.models.Task;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;


@DataJpaTest
@DisplayName("Tests for TasksRepository")
@Log4j2
class TaskRepositoryTest {
    @Autowired
    private TaskRepository repository;
    @Test
    @DisplayName("Save the Taks when successful")
    void save_PersistTask_WhenSuccessful(){
        Task taskToBeSaved = createTask();
        Task taskSaved = this.repository.save(taskToBeSaved);

        Assertions.assertThat(taskSaved).isNotNull();
        Assertions.assertThat(taskSaved.getId()).isNotNull();
        Assertions.assertThat(taskSaved.getTask()).isEqualTo(taskToBeSaved.getTask());
    }
    @Test
    @DisplayName("Update the Taks when successful")
    void save_UpdateTask_WhenSuccessful(){
        Task taskToBeSaved = createTask();
        Task taskSaved = this.repository.save(taskToBeSaved);
        taskSaved.setTask("Correr");
        Task taskUpdated = this.repository.save(taskSaved);

        Assertions.assertThat(taskUpdated).isNotNull();
        Assertions.assertThat(taskUpdated.getId()).isNotNull();
        Assertions.assertThat(taskUpdated.getTask()).isEqualTo(taskSaved.getTask());
    }
    @Test
    @DisplayName("Delete the Taks when successful")
    void delete_RemoveTask_WhenSuccessful(){
        Task taskToBeSaved = createTask();
        Task taskSaved = this.repository.save(taskToBeSaved);

        this.repository.delete(taskSaved);
        Optional<Task> taskOptional = this.repository.findById(taskSaved.getId());
        Assertions.assertThat(taskOptional.isEmpty()).isTrue();
    }

    // TODO: finish the tests of repository
    /*@Test
    @DisplayName("Find the Taks when is complete")
    void findByCompletedTrue_findTaskWhenIsComplete_WhenSuccessful(){
        Task taskToBeSaved = createTask();

        List<Task> taskList = this.repository.findByCompleteFalse();
        taskList;
        Assertions.assertThat(taskList.isComplete()).isTrue();
    }*/
    private Task createTask(){
        return Task.builder()
                .task("Cozinhar")
                .complete(false)
                .build();
    }

}