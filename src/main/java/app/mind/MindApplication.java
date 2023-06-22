package app.mind;


import app.mind.tasks.Tasks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MindApplication {

	public static void main(String[] args) {
		SpringApplication.run(MindApplication.class, args);
	}


	@GetMapping("/hi")
	public String hi() {
		String hi = "2023-06-22";
		return hi;
	}
	@PostMapping("/todo")
	public Tasks toDo() {
		Tasks todo = new Tasks(

				"2023-06-22",
				"2023-06-22",
				"call mechanic",
				"List 1"
		);
		return todo;
	}


}
