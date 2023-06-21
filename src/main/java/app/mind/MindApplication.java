package app.mind;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class MindApplication {

	public static void main(String[] args) {
		SpringApplication.run(MindApplication.class, args);
	}


	@GetMapping("/hi")
	public String hi() {
		return "hi";
	}

}
