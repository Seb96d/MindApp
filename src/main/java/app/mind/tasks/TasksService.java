package app.mind.tasks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Tasks addNewTasks(Tasks tasks) {
        System.out.println("Created new tasks" + tasks);
        return tasksRepository.save(tasks);
    }

    public void saveDetails(Tasks tasks) {
        tasksRepository.save(tasks);
    }

    public void deleteTask(Long id) {
        if(!tasksRepository.existsById(id)) {
            throw new IllegalStateException(
                    "task " + id + " does not exist"
            );
        }
        tasksRepository.deleteById(id);
    }

    public Optional<Tasks> getTaskById(Long id) {
        if(!tasksRepository.existsById(id)) {
            throw new IllegalStateException(
                    "task " + id + " does not exist"
            );
        }
        return tasksRepository.findById(id);
    }
}
