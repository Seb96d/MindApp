package app.mind.tasks;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        tasks.setDateCreated(LocalDate.now().toString());
        tasks.setDateEdit(tasks.getDateCreated());
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
    @GetMapping("{id}")
    public Optional<Tasks> getTaskById(@PathVariable("id") Long id) {
        return tasksService.getTaskById(id);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        tasksService.deleteTask(id);
    }
    @PutMapping("{id}")
    public void updateTask(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String content) {
        tasksService.updateTask(id, content);
    }

}
