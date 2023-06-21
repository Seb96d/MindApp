package app.mind;


import app.mind.tasks.Tasks;
import app.mind.tasks.TasksController;
import app.mind.tasks.TasksService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@SpringBootApplication
@RestController
public class MindApplication {

	public static void main(String[] args) {
		SpringApplication.run(MindApplication.class, args);
	}


	@GetMapping("/hi")
	public String hi() {
		String hi = LocalDate.now().toString();
		return hi;
	}
	Tasks todo = new Tasks(
			LocalDate.now(),
			LocalDate.now(),
			"call mechanic",
			"List 1"
	);

}
