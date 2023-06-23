package app.mind.tasks;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "tasks")
public class TasksController {

    @Autowired
    private final TasksService tasksService;

    @PostMapping("/addTask")
    public void postNewTask(Tasks tasks)
    {
        tasks.setDateCreated(LocalDate.now().toString());
        tasks.setDateEdit(tasks.getDateCreated());
        tasksService.saveDetails(tasks);
    }

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("list")
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
    public void putUpdateTask(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String content) {
        tasksService.updateTask(id, content);
    }




}
