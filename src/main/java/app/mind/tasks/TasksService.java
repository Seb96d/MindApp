package app.mind.tasks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;

    @Autowired
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Tasks> getTasks() {
        return tasksRepository.findAll();
    }

    public void addNewTasks(Tasks tasks) {
        System.out.println(tasks);
        tasksRepository.save(tasks);
    }

}
