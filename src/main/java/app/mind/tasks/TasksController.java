package app.mind.tasks;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tasks")
public class TasksController {

    private final TasksService tasksService;

    @Autowired
    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
    public List<Tasks> getTasks() {
        return tasksService.getTasks();
    }

    @PostMapping
    public void createNewTask(@RequestBody Tasks tasks) {
        tasksService.addNewTasks(tasks);
    }

    @PostMapping
    public void saveNewTask(Tasks tasks) {

    }
}
