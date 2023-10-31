package uia.arqsoft.examen1.model.service;

import uia.arqsoft.examen1.model.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> getTask();
    Optional<Task> getTaskById(Long id);
    void deleteById(Long id);
    void deleteAll();
    Task save(Task task);
}
