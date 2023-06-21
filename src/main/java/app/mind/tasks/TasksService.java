package app.mind.tasks;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TasksService {

    public List<Tasks> getTasks() {
        return List.of(
                new Tasks(
                        1L,
                        LocalDate.now(),
                        LocalDate.now(),
                        "Something to read",
                        "fileLoc"
                )
        );
    }
}
