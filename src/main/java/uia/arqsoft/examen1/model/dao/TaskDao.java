package uia.arqsoft.examen1.model.dao;

import org.springframework.data.repository.CrudRepository;
import uia.arqsoft.examen1.model.entity.Task;

public interface TaskDao extends CrudRepository<Task, Long> {
}
