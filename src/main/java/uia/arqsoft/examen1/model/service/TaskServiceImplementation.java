package uia.arqsoft.examen1.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uia.arqsoft.examen1.model.dao.TaskDao;
import uia.arqsoft.examen1.model.entity.Task;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImplementation implements TaskService {


    /*Autowired es lo que inyecta a nivel atributo, no es seguro ni recomendable
    @Autowired
    private TaskDao taskDao;
     */
    private TaskDao taskDao;

    /*inyección de dependencias por setter, el setter tiene autowired, añade capa de seguridad
    @Autowired
    public void setTaskDao(TaskDao tasDao){
        this.taskDao = taskDao;
    }
    */
    //por constructor, best practice
    @Autowired
    public  TaskServiceImplementation(TaskDao taskDao){
        this.taskDao = taskDao;
    }

    @Override
    public List<Task> getTask(){
        return (List<Task>) taskDao.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id){
        return taskDao.findById(id);
    }

    @Override
    public void deleteById(Long id){
         taskDao.deleteById(id);
    }

    @Override
    public void deleteAll(){
        taskDao.deleteAll();
    }

    @Override
    public Task save(Task task) {
        taskDao.save(task);
        return task;
    }
}
