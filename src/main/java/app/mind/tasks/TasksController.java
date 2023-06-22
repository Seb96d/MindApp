package app.mind.tasks;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "tasks")
public class TasksController {
//"dateCreated": "2023-06-22",
//        "dateEdit": "2023-06-22",
//        "content": "conteeent2",
//        "address": "adresik2"
    @Autowired
    private final TasksService tasksService;

    @PostMapping("/addTask")
    public void postDetails(Tasks tasks)
    {
         tasksService.saveDetails(tasks);
    }
    @PostMapping("/add")
    public Tasks createNewTask(Tasks tasks) {
        return tasksService.addNewTasks(tasks);
    }

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
    public List<Tasks> getTasks() {
        return tasksService.getTasks();
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        tasksService.deleteTask(id);
    }
}
