package app.mind.tasks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TasksService {
    public int countGetAll = 0;
    public int countGetById = 0;
    public int countPost = 0;
    public int countDelete = 0;
    public int countPut = 0;

    private final TasksRepository tasksRepository;

    @Autowired
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Tasks> getTasks() {
        countGetAll++;
        return tasksRepository.findAll();
    }

    public Tasks addNewTasks(Tasks tasks) {
        countPost++;
        System.out.println("Created new tasks" + tasks);
        return tasksRepository.save(tasks);
    }

    public void saveDetails(Tasks tasks) {
        countPost++;
        tasksRepository.save(tasks);
    }

    public void deleteTask(Long id) {
        if(!tasksRepository.existsById(id)) {
            throw new IllegalStateException(
                    "task " + id + " does not exist"
            );
        }
        countDelete++;
        tasksRepository.deleteById(id);
    }

    public Optional<Tasks> getTaskById(Long id) {
        if(!tasksRepository.existsById(id)) {
            throw new IllegalStateException(
                    "task " + id + " does not exist"
            );
        }
        countGetById++;
        return tasksRepository.findById(id);
    }
    @Transactional
    public void updateTask(Long id, String content) {
        Tasks task = tasksRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                "task with id " + id + " does not exist"));
        if (content != null && content.length() > 0 && !Objects.equals(task.getContent(), content)) {
            countPut++;
            task.setContent(content);
            task.setDateEdit(LocalDate.now().toString());
        }
    }
}
