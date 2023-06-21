package app.mind.tasks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class TasksConfig {



    Tasks shopping = new Tasks(
            1l,
            LocalDate.now(),
            LocalDate.now(),
            "Buy eggs",
            "List 1"
    );


}
