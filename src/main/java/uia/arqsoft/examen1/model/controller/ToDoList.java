package uia.arqsoft.examen1.model.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uia.arqsoft.examen1.model.entity.Task;
import uia.arqsoft.examen1.model.service.TaskService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping(value = "list")
public class ToDoList {
    @Autowired
    private TaskService taskService;

    @GetMapping(value = "tasks")
    public String getTasks(Model model){
        List<Task> list = taskService.getTask();
        model.addAttribute("table", list);
        return "tasks/index";
    }

    @GetMapping(value="tasks/{id}")
    public String getTaskById(@PathVariable(name="id") Long id, Model model){
        Optional<Task> task = taskService.getTaskById(id);
        if(task.isPresent()){
            List <Task> list = new ArrayList<>();
            list.add(task.get());
            log.info("Controller - getTaskById - task {}", list);
            model.addAttribute("table", list);
        }else
            model.addAttribute("table", null);
        return "tasks/index";
    }

    @GetMapping(value = "delete/{id}")
    public String deleteTaskById(@PathVariable(name="id") Long id, Model model){
        taskService.deleteById(id);
        List <Task> list = taskService.getTask();
        model.addAttribute("table", list);
        return "tasks/index";
    }

    @GetMapping(value = "new")
    public String newTask(Model model){
        Task myTask = new Task();
        model.addAttribute("Object", myTask);
        return "tasks/form";
    }

    @PostMapping(value = "save")
    public String saveTask(@ModelAttribute("Object") Task task, Model model) throws IOException {
        log.info("Controller - save - task {}", task);
        log.info("Controller - save - task {}", task.getId());
        log.info("Controller - save - task {}", task.getStatus());
        log.info("Controller - save - task {}", task.getDescription());
        log.info("Controller - save - task {}", task.getCreationDate());
        Task myTask = taskService.save(task);
        List <Task> list = new ArrayList<>();
        list.add(myTask);
        model.addAttribute("table", list);
        return "tasks/index";
    }

    /*@GetMapping(value = "update/{id}")
    public String updateTask(@PathVariable(name = "id") Long id, Model model) throws IOException {
        Optional<Task> taskData = taskService.getTaskById(id);
        if(taskData.isPresent()){
            Task myTask = new taskData.get();
            model.addAttribute("Object", myTask);
        }else{
            model.addAttribute("table", null);

        }
        return "tasks/form";
    }*/
}
